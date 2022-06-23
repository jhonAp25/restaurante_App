package com.idat.demo.controller;


import com.idat.demo.model.Plato;
import com.idat.demo.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plato")
@CrossOrigin(origins = "*")
public class PlatoController {


    @Autowired
    private PlatoService  service;

    @GetMapping
    public ResponseEntity<?>listado(){
        return new  ResponseEntity<>(service.list(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> busqueda(@PathVariable Long id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saved(@RequestBody Plato plato){
        return new ResponseEntity<>(service.save(plato) , HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> actualizar(@RequestBody Plato plato){
        return new ResponseEntity<>(service.update(plato) , HttpStatus.OK);
    }
}
