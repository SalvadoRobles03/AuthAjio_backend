package com.salvadorobles03.authajio.entities;

import jakarta.persistence.*;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Usuarios")
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String nombre;

  @ManyToMany
  @JoinTable(
      name = "usuario_cuenta",
      joinColumns = @JoinColumn(name = "usuario_id"),
      inverseJoinColumns = @JoinColumn(name = "cuenta_id"))
  @JsonManagedReference
  private Set<Cuenta> cuentas;

  public Usuario(String nombre, Set<Cuenta> cuentas) {
    this.nombre = nombre;
    this.cuentas = cuentas;
  }

  public Usuario(String nombre) {
    this.nombre = nombre;
  }

  public Usuario() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Set<Cuenta> getCuentas() {
    return cuentas;
  }

  public void setCuentas(Set<Cuenta> cuentas) {
    this.cuentas = cuentas;
  }
}
