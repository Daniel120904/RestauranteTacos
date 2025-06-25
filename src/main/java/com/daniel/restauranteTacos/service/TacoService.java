package com.daniel.restauranteTacos.service;

import com.daniel.restauranteTacos.model.TacoModel;
import com.daniel.restauranteTacos.repository.TacoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TacoService {

    @Autowired
    private TacoRepository tacoRepository;

    public List<TacoModel> listarTodos() {
        return tacoRepository.findAll();
    }

    public Optional<TacoModel> buscarPorId(String id) {
        return tacoRepository.findById(id);
    }

    public TacoModel salvar(TacoModel taco) {
        return tacoRepository.save(taco);
    }

    public void deletar(String id) {
        tacoRepository.deleteById(id);
    }
}
