package com.idat.demo.service;


import com.idat.demo.model.Mesa;
import com.idat.demo.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaService {


    @Autowired
    private MesaRepository repository;

    public List<Mesa> listado(){
        return repository.findAll();
    }


    public Mesa busqueda(Long id){
        return repository.findById(id).orElse(null);
    }

    public Mesa save( Mesa mesa){
        return repository.save(mesa);
    }

    public Mesa update( Mesa mesa){

        Mesa mesaNew = busqueda(mesa.getId());

        if (mesa.getNroMesa() != null)
            mesaNew.setNroMesa(mesa.getNroMesa());

        return repository.save(mesaNew);
    }


}
