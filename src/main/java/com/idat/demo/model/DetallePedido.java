package com.idat.demo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetallePedido {

    @Id
    @GeneratedValue
    private Long id;
    private String cantidad;

    @ManyToOne
    private Pedido  pedido;




}
