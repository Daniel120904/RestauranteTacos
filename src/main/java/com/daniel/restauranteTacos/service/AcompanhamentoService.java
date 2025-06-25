package com.daniel.restauranteTacos.service;

import com.daniel.restauranteTacos.model.AcompanhamentoModel;
import com.daniel.restauranteTacos.repository.AcompanhamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AcompanhamentoService {

    @Autowired
    private AcompanhamentoRepository acompanhamentoRepository;

    public List<AcompanhamentoModel> listarTodos() {return acompanhamentoRepository.findAll();}

    public Optional<AcompanhamentoModel> buscarPorId(String id) {return acompanhamentoRepository.findById(id);}

    public AcompanhamentoModel salvar(AcompanhamentoModel acompanhamento) {return acompanhamentoRepository.save(acompanhamento);}

    public void deletar(String id) {acompanhamentoRepository.deleteById(id);}
}

