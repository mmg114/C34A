package com.parquesoftti.C34A.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parquesoftti.C34A.model.Cliente;
import com.parquesoftti.C34A.service.ClienteService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {
    

    private final ClienteService clienteService;
    
   @GetMapping("/{id}")
   public ResponseEntity<Cliente> findById(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.findById(id));
   }


   @GetMapping
   public ResponseEntity<List<Cliente>> findAll(){
      return ResponseEntity.ok(clienteService.findAll());
   }

   
   @GetMapping("/nombre/{nombre}")
   public ResponseEntity<Cliente> findByNombre(@PathVariable String nombre){
      return ResponseEntity.ok(clienteService.findByNombre(nombre));
   }



     @DeleteMapping("/{id}")
     public ResponseEntity<Void> delete(@PathVariable Long id){
          clienteService.delete(id);
          return ResponseEntity.noContent().build();
     }

     @PostMapping
     public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
          return ResponseEntity.ok(clienteService.save(cliente));
     }

     @PutMapping("/{id}")
     public ResponseEntity<Cliente> update(@RequestBody Cliente cliente,@PathVariable Long id){
          return ResponseEntity.ok(clienteService.update(cliente,id));
     }


}
