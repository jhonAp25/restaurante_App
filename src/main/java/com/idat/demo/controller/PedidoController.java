package com.idat.demo.controller;


import com.idat.demo.model.Mesa;
import com.idat.demo.model.Pedido;
import com.idat.demo.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
@CrossOrigin(origins = "*")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @GetMapping
    public ResponseEntity<?> listado(){
        return new  ResponseEntity<>(service.listado(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> busqueda(@PathVariable Long id){
        return new ResponseEntity<>(service.busqueda(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saved(@RequestBody Pedido pedido){
        return new ResponseEntity<>(service.save(pedido) , HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> actualizar(@RequestBody Pedido pedido){
        return new ResponseEntity<>(service.update(pedido) , HttpStatus.OK);
    }

}
