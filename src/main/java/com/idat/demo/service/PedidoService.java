package com.idat.demo.service;


import com.idat.demo.model.Mozo;
import com.idat.demo.model.Pedido;
import com.idat.demo.repository.MozoRepository;
import com.idat.demo.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;



    public List<Pedido> listado(){
        return repository.findAll();
    }


    public Pedido busqueda(Long id){
        return repository.findById(id).orElse(null);
    }

    public Pedido save( Pedido pedido){
        return repository.save( pedido);
    }

    public Pedido update( Pedido pedido){

        Pedido pedidoNew = busqueda(pedido.getId());

        if (pedido.getDescripcion() != null)
            pedidoNew.setDescripcion(pedido.getDescripcion());

        if (pedido.getTotal() != null)
            pedidoNew.setDescripcion(pedido.getDescripcion());

        if (pedido.getDetallePedido() != null)
            pedidoNew.setDetallePedido(pedido.getDetallePedido());

        return repository.save(pedidoNew);
    }

}
