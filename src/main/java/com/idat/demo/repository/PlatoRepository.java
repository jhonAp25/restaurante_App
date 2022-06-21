package com.idat.demo.repository;

import com.idat.demo.model.Plato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlatoRepository extends JpaRepository<Plato, Long> {
}
