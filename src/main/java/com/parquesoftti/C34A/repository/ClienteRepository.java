package com.parquesoftti.C34A.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parquesoftti.C34A.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
        // select * from cliente where nombre = ?
    Optional<Cliente> findByNombre(String nombre);
    
}
