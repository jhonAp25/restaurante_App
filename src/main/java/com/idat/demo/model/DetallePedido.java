package com.idat.demo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "detalle_pedido")
public class DetallePedido {

    @Id
    @GeneratedValue
    private Long id;
    private int cantidad;


    @ManyToOne
    private Plato plato;

    @ManyToOne
    private Mesa mesa;

    @ManyToOne
    private Mozo mozo;

    @ManyToOne
    private Pedido pedido;





}
