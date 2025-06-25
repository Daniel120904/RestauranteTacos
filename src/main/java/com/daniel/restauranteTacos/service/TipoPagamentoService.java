package com.daniel.restauranteTacos.service;

import com.daniel.restauranteTacos.model.PagamentoModel;
import com.daniel.restauranteTacos.model.TipoPagamentoModel;
import com.daniel.restauranteTacos.repository.TipoPagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TipoPagamentoService {

    private final TipoPagamentoRepository tipoPagamentoRepository;

    public List<TipoPagamentoModel> listarTodos() {return tipoPagamentoRepository.findAll();}

    public Optional<TipoPagamentoModel> buscarPorId(String id) {return tipoPagamentoRepository.findById(id);}

    public TipoPagamentoModel salvar(TipoPagamentoModel pagamento) {
        return tipoPagamentoRepository.save(pagamento);
    }

    public void deletar(String id) {
        tipoPagamentoRepository.deleteById(id);
    }

}
