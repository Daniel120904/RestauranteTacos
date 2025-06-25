package com.daniel.restauranteTacos.service;

import com.daniel.restauranteTacos.dto.PedidoRequestDTO;
import com.daniel.restauranteTacos.dto.PedidoResponseDTO;
import com.daniel.restauranteTacos.enums.TipoItem;
import com.daniel.restauranteTacos.model.*;
import com.daniel.restauranteTacos.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final TacoRepository tacoRepository;
    private final BebidaRepository bebidaRepository;
    private final AcompanhamentoRepository acompanhamentoRepository;
    private final PedidoRepository pedidoRepository;
    private final PagamentoService pagamentoService;

    public PedidoModel criarPedido(PedidoRequestDTO dto) {
        List<ItemPedidoModel> itens = new ArrayList<>();

        processarItens(dto.getTacosIds(), itens, TipoItem.TACO);
        processarItens(dto.getBebidasIds(), itens, TipoItem.BEBIDA);
        processarItens(dto.getAcompanhamentosIds(), itens, TipoItem.ACOMPANHAMENTO);

        PedidoModel pedido = new PedidoModel();
        pedido.setNomeCliente(dto.getNomeCliente());
        pedido.setItens(itens);
        pedido.calcularValorTotal();

        return pedidoRepository.save(pedido);
    }

    private void processarItens(List<String> ids, List<ItemPedidoModel> itens, TipoItem tipo) {
        for (String id : ids) {
            switch (tipo) {
                case TACO -> {
                    var taco = tacoRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Taco não encontrado"));
                    adicionarOuIncrementarItem(itens, taco.getId(), taco.getDescricao(), taco.getPreco(), tipo);
                }
                case BEBIDA -> {
                    var bebida = bebidaRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Bebida não encontrada"));
                    adicionarOuIncrementarItem(itens, bebida.getId(), bebida.getDescricao(), bebida.getPreco(), tipo);
                }
                case ACOMPANHAMENTO -> {
                    var acompanhamento = acompanhamentoRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Acompanhamento não encontrado"));
                    adicionarOuIncrementarItem(itens, acompanhamento.getId(), acompanhamento.getDescricao(), acompanhamento.getPreco(), tipo);
                }
            }
        }
    }

    private void adicionarOuIncrementarItem(List<ItemPedidoModel> itens, String id, String descricao, double preco, TipoItem tipo) {
        Optional<ItemPedidoModel> existente = itens.stream()
                .filter(item -> item.getIdItem().equals(id) && item.getTipo() == tipo)
                .findFirst();

        if (existente.isPresent()) {
            existente.get().setQuantidade(existente.get().getQuantidade() + 1);
        } else {
            itens.add(new ItemPedidoModel(id, descricao, preco, 1, tipo));
        }
    }

    public PedidoResponseDTO converterParaResponse(PedidoModel pedido) {
        PedidoResponseDTO dto = new PedidoResponseDTO();

        dto.setId(pedido.getId());
        dto.setNomeCliente(pedido.getNomeCliente());

        dto.setTacos(
                pedido.getItens().stream()
                        .filter(item -> item.getTipo() == TipoItem.TACO)
                        .map(item -> item.getDescricao() + " (x" + item.getQuantidade() + ")")
                        .toList()
        );

        dto.setBebidas(
                pedido.getItens().stream()
                        .filter(item -> item.getTipo() == TipoItem.BEBIDA)
                        .map(item -> item.getDescricao() + " (x" + item.getQuantidade() + ")")
                        .toList()
        );

        dto.setAcompanhamentos(
                pedido.getItens().stream()
                        .filter(item -> item.getTipo() == TipoItem.ACOMPANHAMENTO)
                        .map(item -> item.getDescricao() + " (x" + item.getQuantidade() + ")")
                        .toList()
        );

        dto.setPrecoTotal(pedido.getValorTotal());

        if (pedido.getPagamento() != null) {
            dto.setTipoPagamento(pedido.getPagamento().getTipoPagamento().getNome());
            dto.setDataPagamento(pedido.getPagamento().getDataPagamento());
        }

        return dto;
    }

    public List<PedidoModel> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Optional<PedidoModel> buscarPorId(String id) {
        return pedidoRepository.findById(id);
    }

    public PedidoModel adicionarPagamento(String pedidoId, String tipoPagamentoId) {
        PedidoModel pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        var pagamento = pagamentoService.criarPagamento(tipoPagamentoId);

        pedido.setPagamento(pagamento);

        return pedidoRepository.save(pedido);
    }

    public void deletar(String id) {
        pedidoRepository.deleteById(id);
    }
}
