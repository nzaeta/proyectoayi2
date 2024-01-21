package com.ayi.EjercicioEvaluativo2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table (name="proveedor")
public class Proveedor implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProveedor;
    private String nombre;
    private String telefono;
    private String direccion;
    private String email;
    private String sitioWeb;
    private int estado;

}
