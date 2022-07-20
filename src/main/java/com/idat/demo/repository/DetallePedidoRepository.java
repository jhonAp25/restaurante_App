package com.idat.demo.repository;

import com.idat.demo.model.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {

    List<DetallePedido> findAllByPedidoId(Long id);
}
