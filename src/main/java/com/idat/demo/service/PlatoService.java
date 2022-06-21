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

    private Plato save(Plato plato){
        return repository.save(plato);
    }


}
