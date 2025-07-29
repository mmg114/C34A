package com.parquesoftti.C34A.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parquesoftti.C34A.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
}
