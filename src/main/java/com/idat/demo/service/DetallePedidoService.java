package com.idat.demo.service;


import com.idat.demo.model.DetallePedido;
import com.idat.demo.model.Pedido;
import com.idat.demo.repository.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DetallePedidoService {

    @Autowired
    private DetallePedidoRepository repository;

    @Autowired
    private PedidoService pedidoService;



    public List<DetallePedido> listado(){
        return repository.findAll();
    }


    public DetallePedido busqueda(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<DetallePedido> filtroPedido(Long id){
        return repository.findAllByPedidoId(id);
    }


    public DetallePedido save( DetallePedido detallePedido){

        DetallePedido newDetalle = new DetallePedido();

       if (pedidoService.busqueda(detallePedido.getPedido().getId()) == null ){

            Pedido pedido = new Pedido();
            pedido.setFecha(LocalDate.now());
            pedido.setTotal(0.0);
            newDetalle.setPedido(pedidoService.save(pedido));

        }else {
            newDetalle.setPedido(detallePedido.getPedido());
        }

        newDetalle.setCantidad(detallePedido.getCantidad());
        newDetalle.setMesa(detallePedido.getMesa());
        newDetalle.setMozo(detallePedido.getMozo());
        newDetalle.setPlato(detallePedido.getPlato());

        return repository.save( newDetalle);
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
            msj="Plato eliminado";
        }

        return msj;
    }



}
