package com.parquesoftti.C34A.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "clientes")
@Data
public class Cliente {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String nombre;
   private String telefono;




}
