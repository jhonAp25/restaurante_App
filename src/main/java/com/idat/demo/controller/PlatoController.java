package com.idat.demo.controller;


import com.idat.demo.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
