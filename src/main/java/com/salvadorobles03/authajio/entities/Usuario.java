package com.salvadorobles03.authajio.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Usuarios")
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String nombre;

  @ManyToMany(mappedBy = "usuarios")
  private Set<Cuenta> cuentas;

  public Usuario(String nombre, Set<Cuenta> cuentas) {
    this.nombre = nombre;
    this.cuentas = cuentas;
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
