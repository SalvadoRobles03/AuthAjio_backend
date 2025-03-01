package com.salvadorobles03.authajio.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuarios")
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String nombre;

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
}
