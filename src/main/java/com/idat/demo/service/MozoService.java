package com.idat.demo.service;


import com.idat.demo.model.Mesa;
import com.idat.demo.model.Mozo;
import com.idat.demo.repository.MozoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MozoService {

    @Autowired
    private MozoRepository repository;

    public List<Mozo> listado(){
        return repository.findAll();
    }


    public Mozo busqueda(Long id){
        return repository.findById(id).orElse(null);
    }

    public Mozo save( Mozo mozo){
        return repository.save(mozo);
    }

    public Mozo update( Mozo mozo){

        Mozo mozoNew = busqueda(mozo.getId());

        if (mozo.getNombre() != null)
            mozoNew.setNombre(mozo.getNombre());

        if (mozo.getApellido() != null)
            mozoNew.setApellido(mozo.getApellido());

        if (mozo.getCorreo() != null)
            mozoNew.setCorreo(mozo.getCorreo());

        if (mozo.getDni() != null)
            mozoNew.setDni(mozo.getDni());

        if (mozo.getTelefono() != null)
            mozoNew.setTelefono(mozo.getTelefono());


        return repository.save(mozoNew);
    }
}
