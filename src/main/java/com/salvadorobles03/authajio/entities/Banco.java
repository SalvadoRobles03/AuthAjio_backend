package com.salvadorobles03.authajio.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Bancos")
public class Banco {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(length = 3)
  private int no_banco;

  private String nombre;

  public Banco(int no_banco, String nombre) {
    this.no_banco = no_banco;
    this.nombre = nombre;
  }

  public Banco() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getNo_banco() {
    return no_banco;
  }

  public void setNo_banco(int no_banco) {
    this.no_banco = no_banco;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
}
