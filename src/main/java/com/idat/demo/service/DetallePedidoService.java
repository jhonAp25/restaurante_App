package com.idat.demo.service;


import com.idat.demo.model.DetallePedido;
import com.idat.demo.model.Pedido;
import com.idat.demo.repository.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoService {

    @Autowired
    private DetallePedidoRepository repository;



    public List<DetallePedido> listado(){
        return repository.findAll();
    }


    public DetallePedido busqueda(Long id){
        return repository.findById(id).orElse(null);
    }

    public DetallePedido save( DetallePedido detallePedido){
        return repository.save( detallePedido);
    }

    public DetallePedido update( DetallePedido detallePedido){

        DetallePedido detallePedidoNew = busqueda(detallePedido.getId());

        if (detallePedido.getCantidad() != 0)
            detallePedidoNew.setCantidad(detallePedido.getCantidad());

        if (detallePedido.getMesa() != null)
            detallePedidoNew.setMesa(detallePedido.getMesa());

        if (detallePedido.getMozo() != null)
            detallePedidoNew.setMozo(detallePedido.getMozo());

        if (detallePedido.getPlato() != null)
            detallePedidoNew.setPlato(detallePedido.getPlato());

        return repository.save(detallePedidoNew);
    }


    public String delete(Long id){

        String msj = "";
        DetallePedido detallePedido = busqueda(id);

        if (detallePedido == null){
            msj = "No existe este pedido";
        }else {
            repository.delete(detallePedido);
        }

        return msj;
    }



}
