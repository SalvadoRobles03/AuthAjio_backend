package com.salvadorobles03.authajio.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Creditos")
public class Credito {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @OneToOne
  @JoinColumn(name = "id_usuario")
  private Usuario usuario;

  private double credito_total;
  private double credito_gastado;

  public Credito(Usuario usuario, double credito_total, double credito_gastado) {
    this.usuario = usuario;
    this.credito_total = credito_total;
    this.credito_gastado = credito_gastado;
  }

  public Credito() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public double getCredito_total() {
    return credito_total;
  }

  public void setCredito_total(double credito_total) {
    this.credito_total = credito_total;
  }

  public double getCredito_gastado() {
    return credito_gastado;
  }

  public void setCredito_gastado(double credito_gastado) {
    this.credito_gastado = credito_gastado;
  }
}
