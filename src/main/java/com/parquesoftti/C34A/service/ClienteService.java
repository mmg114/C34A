package com.parquesoftti.C34A.service;

import java.util.List;

import com.parquesoftti.C34A.model.Cliente;

public interface ClienteService {
    public Cliente save(Cliente cliente);
    public Cliente findById(Long id);
    public List<Cliente> findAll();
    public Cliente findByNombre(String nombre);
    public Cliente update(Cliente cliente,Long id);
    public void delete(Long id);
}
