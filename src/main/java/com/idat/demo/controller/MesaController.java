package com.idat.demo.controller;


import com.idat.demo.model.Mesa;
import com.idat.demo.model.Plato;
import com.idat.demo.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mesa")
@CrossOrigin(origins = "*")
public class MesaController {

    @Autowired
    private MesaService service;

    @GetMapping
    public ResponseEntity<?> listado(){
        return new  ResponseEntity<>(service.listado(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> busqueda(@PathVariable Long id){
        return new ResponseEntity<>(service.busqueda(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saved(@RequestBody Mesa mesa){
        return new ResponseEntity<>(service.save(mesa) , HttpStatus.OK);
    }

    @PutMapping("/updateEstado")
    public ResponseEntity<?> updateEstado(@RequestBody Mesa mesa){
        return new ResponseEntity<>(service.updateEstado(mesa) , HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> actualizar(@RequestBody Mesa mesa){
        return new ResponseEntity<>(service.update(mesa) , HttpStatus.OK);
    }
}
