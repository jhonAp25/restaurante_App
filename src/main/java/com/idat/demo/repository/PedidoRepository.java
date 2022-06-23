package com.idat.demo.repository;

import com.idat.demo.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido , Long> {
}
