package com.daniel.restauranteTacos.service;

import com.daniel.restauranteTacos.model.PagamentoModel;
import com.daniel.restauranteTacos.model.TipoPagamentoModel;
import com.daniel.restauranteTacos.repository.PagamentoRepository;
import com.daniel.restauranteTacos.repository.TipoPagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;
    private final TipoPagamentoRepository tipoPagamentoRepository;

    public PagamentoModel criarPagamento(String idTipoPagamento) {
        TipoPagamentoModel tipo = tipoPagamentoRepository.findById(idTipoPagamento)
                .orElseThrow(() -> new RuntimeException("Tipo de pagamento não encontrado"));

        PagamentoModel pagamento = new PagamentoModel();
        pagamento.setTipoPagamento(tipo);
        pagamento.setDataPagamento(LocalDateTime.now());

        return pagamentoRepository.save(pagamento);
    }

    public List<PagamentoModel> listarPagamentos() {return pagamentoRepository.findAll();}

    public Optional<PagamentoModel> buscarPorId(String id) {return pagamentoRepository.findById(id);}

    public void deletar(String id) {pagamentoRepository.deleteById(id);}
}
