package com.idat.demo.controller;


import com.idat.demo.model.DetallePedido;
import com.idat.demo.model.Pedido;
import com.idat.demo.service.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/detallePedido")
@CrossOrigin(origins = "*")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoService service;


    @GetMapping
    public ResponseEntity<?> listado(){
        return new  ResponseEntity<>(service.listado(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> busqueda(@PathVariable Long id){
        return new ResponseEntity<>(service.busqueda(id), HttpStatus.OK);
    }

    @GetMapping("/filtro/{id}")
    public ResponseEntity<?> filtro_por_pedido(@PathVariable Long id){
        return new ResponseEntity<>(service.filtroPedido(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saved(@RequestBody DetallePedido pedido){
        return new ResponseEntity<>(service.save(pedido) , HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> actualizar(@RequestBody DetallePedido pedido){
        return new ResponseEntity<>(service.update(pedido) , HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return new ResponseEntity<>(service.delete(id) , HttpStatus.OK);
    }
}
