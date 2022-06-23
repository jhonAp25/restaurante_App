package com.idat.demo.controller;


import com.idat.demo.model.Mesa;
import com.idat.demo.model.Mozo;
import com.idat.demo.service.MozoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mozo")
@CrossOrigin(origins = "*")
public class MozoController {

    @Autowired
    private MozoService service;

    @GetMapping
    public ResponseEntity<?> listado(){
        return new  ResponseEntity<>(service.listado(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> busqueda(@PathVariable Long id){
        return new ResponseEntity<>(service.busqueda(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saved(@RequestBody Mozo mozo){
        return new ResponseEntity<>(service.save(mozo) , HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> actualizar(@RequestBody Mozo mozo){
        return new ResponseEntity<>(service.update(mozo) , HttpStatus.OK);
    }


}
