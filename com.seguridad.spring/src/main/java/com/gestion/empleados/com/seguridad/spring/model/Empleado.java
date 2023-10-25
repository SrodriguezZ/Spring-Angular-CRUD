
package com.gestion.empleados.com.seguridad.spring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter@Setter
@Table(name="empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nombre", length = 60, nullable = false)
    private String nombres;
    @Column(name="apellido", length = 60, nullable = false)
    private String apellido;
    @Column(name="email", length = 60, nullable = false, unique = true)
    private String email;

    public Empleado() {
    }
    
}
