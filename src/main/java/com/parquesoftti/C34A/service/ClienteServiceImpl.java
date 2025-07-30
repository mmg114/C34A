package com.parquesoftti.C34A.service;

import java.util.List;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.parquesoftti.C34A.model.Cliente;
import com.parquesoftti.C34A.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {
    
    private final ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public Cliente findById(Long id){
       if(id == null){
        throw new RuntimeException("El id no puede ser nulo");
       }   
        return clienteRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Cliente findByNombre(String nombre){
       
        if(nombre == null || nombre.isEmpty() || nombre.isBlank()){
            throw new RuntimeException("El nombre no puede ser nulo o vacio");
        }
   
        return clienteRepository.findByNombre(nombre).orElse(null);
    }

    @Transactional(readOnly = false, rollbackFor = RuntimeException.class)
    public Cliente update(Cliente cliente,Long id){
        boolean clienteExistente = clienteRepository.existsById(id);

        if(!clienteExistente){
            throw new RuntimeException("El cliente no existe");
        }
        return  clienteRepository.save(cliente);
    }

    @Transactional(readOnly = false, rollbackFor = RuntimeException.class)
    public void delete(Long id){
        Cliente cliente = findById(id);
        if(cliente == null){
            throw new RuntimeException("El cliente no existe");
        }
        clienteRepository.delete(cliente);
    }

    @Transactional(readOnly = false, rollbackFor = RuntimeException.class)
    public Cliente save(Cliente client) {
       
       Cliente cliente = new Cliente();
       cliente.setNombre(client.getNombre());
       cliente.setTelefono(client.getTelefono());

        return clienteRepository.save(cliente);
    }
}
