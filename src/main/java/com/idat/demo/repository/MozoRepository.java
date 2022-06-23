package com.idat.demo.repository;

import com.idat.demo.model.Mozo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MozoRepository extends JpaRepository<Mozo, Long> {
}
