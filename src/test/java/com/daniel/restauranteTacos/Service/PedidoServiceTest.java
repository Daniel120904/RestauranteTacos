package com.daniel.restauranteTacos.Service;

import com.daniel.restauranteTacos.dto.PedidoRequestDTO;
import com.daniel.restauranteTacos.model.*;
import com.daniel.restauranteTacos.repository.*;

import com.daniel.restauranteTacos.service.PagamentoService;
import com.daniel.restauranteTacos.service.PedidoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PedidoServiceTest {

    @Mock
    private TacoRepository tacoRepository;

    @Mock
    private BebidaRepository bebidaRepository;

    @Mock
    private AcompanhamentoRepository acompanhamentoRepository;

    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private PagamentoService pagamentoService;

    @InjectMocks
    private PedidoService pedidoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void criarPedido_deveCriarPedidoComItensCorretos() {
        // Dados simulados
        TacoModel taco = new TacoModel("1", "Taco de Carne", 10.0);
        BebidaModel bebida = new BebidaModel("2", "Guaraná", 5.0);
        AcompanhamentoModel acompanhamento = new AcompanhamentoModel("3", "Pimenta", 1.0);

        // Mock dos repositórios
        when(tacoRepository.findById("1")).thenReturn(Optional.of(taco));
        when(bebidaRepository.findById("2")).thenReturn(Optional.of(bebida));
        when(acompanhamentoRepository.findById("3")).thenReturn(Optional.of(acompanhamento));

        // Aqui o segredo
        when(pedidoRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

        // DTO de entrada
        PedidoRequestDTO dto = new PedidoRequestDTO();
        dto.setNomeCliente("Daniel");
        dto.setTacosIds(List.of("1"));
        dto.setBebidasIds(List.of("2", "2")); // duas bebidas
        dto.setAcompanhamentosIds(List.of("3"));

        // Executa
        PedidoModel resultado = pedidoService.criarPedido(dto);

        // Verificações
        assertNotNull(resultado);
        assertEquals("Daniel", resultado.getNomeCliente());
        assertEquals(3, resultado.getItens().size());

        // Verifica que bebida está com quantidade 2
        var bebidaItem = resultado.getItens().stream()
                .filter(item -> item.getIdItem().equals("2"))
                .findFirst();

        assertTrue(bebidaItem.isPresent());
        assertEquals(2, bebidaItem.get().getQuantidade());

        assertEquals(10 + (5 * 2) + 1, resultado.getValorTotal()); // Total = 21
    }


    @Test
    void adicionarPagamento_deveAssociarPagamentoAoPedido() {
        // Arrange (preparação dos dados)
        String pedidoId = "pedido123";
        String tipoPagamentoId = "pix";

        PedidoModel pedidoExistente = new PedidoModel();
        pedidoExistente.setId(pedidoId);

        TipoPagamentoModel tipoPagamento = new TipoPagamentoModel();
        tipoPagamento.setId(tipoPagamentoId);
        tipoPagamento.setNome("PIX");

        PagamentoModel pagamento = new PagamentoModel();
        pagamento.setTipoPagamento(tipoPagamento);

        when(pedidoRepository.findById(pedidoId)).thenReturn(Optional.of(pedidoExistente));
        when(pagamentoService.criarPagamento(tipoPagamentoId)).thenReturn(pagamento);
        when(pedidoRepository.save(any(PedidoModel.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act (execução)
        PedidoModel pedidoComPagamento = pedidoService.adicionarPagamento(pedidoId, tipoPagamentoId);

        // Assert (validação)
        assertNotNull(pedidoComPagamento.getPagamento(), "O pagamento deve estar associado");
        assertEquals("PIX", pedidoComPagamento.getPagamento().getTipoPagamento().getNome());
        assertEquals(pedidoId, pedidoComPagamento.getId());

        // Verifica se os métodos foram chamados
        verify(pedidoRepository, times(1)).findById(pedidoId);
        verify(pagamentoService, times(1)).criarPagamento(tipoPagamentoId);
        verify(pedidoRepository, times(1)).save(pedidoComPagamento);
    }
}
