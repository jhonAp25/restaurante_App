package com.idat.demo.service;


import com.idat.demo.model.Plato;
import com.idat.demo.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatoService {

    @Autowired
    private PlatoRepository repository;

    public List<Plato> list(){
        return repository.findAll();
    }

    public Plato findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public Plato save(Plato plato){
        return repository.save(plato);
    }


    public Plato update(Plato plato){
        Plato plato1 = findById(plato.getId());
        if (plato.getDescripcion() != null)
            plato1.setDescripcion(plato.getDescripcion());

        if (plato.getPrecio() != 0)
            plato1.setPrecio(plato.getPrecio());

        return repository.save(plato);
    }


}
