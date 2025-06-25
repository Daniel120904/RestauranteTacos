package com.daniel.restauranteTacos.service;

import com.daniel.restauranteTacos.model.BebidaModel;
import com.daniel.restauranteTacos.repository.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BebidaService {

    @Autowired
    private BebidaRepository bebidaRepository;

    public List<BebidaModel> listarTodos() {return bebidaRepository.findAll();}

    public Optional<BebidaModel> buscarPorId(String id) {return bebidaRepository.findById(id);}

    public BebidaModel salvar(BebidaModel bebida) {return bebidaRepository.save(bebida);}

    public void deletar(String id) {bebidaRepository.deleteById(id);}

}
