package com.salvadorobles03.authajio.entities;

import jakarta.persistence.*;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Cuentas")
public class Cuenta {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private double saldo;

  @Column(length = 11)
  private String numero_cuenta;

  @Column(length = 18)
  private String clabe;

  @ManyToOne
  @JoinColumn(name = "id_banco")
  private Banco banco;

  @ManyToMany(mappedBy = "cuentas")
  @JsonIgnore
  private Set<Usuario> usuarios;

  public Cuenta(
      double saldo, String numero_cuenta, String clabe, Banco banco, Set<Usuario> usuarios) {
    this.saldo = saldo;
    this.numero_cuenta = numero_cuenta;
    this.clabe = clabe;
    this.banco = banco;
    this.usuarios = usuarios;
  }

  public Cuenta() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

  public String getNumero_cuenta() {
    return numero_cuenta;
  }

  public void setNumero_cuenta(String numero_cuenta) {
    this.numero_cuenta = numero_cuenta;
  }

  public String getClabe() {
    return clabe;
  }

  public void setClabe(String clabe) {
    this.clabe = clabe;
  }

  public Banco getBanco() {
    return banco;
  }

  public void setBanco(Banco banco) {
    this.banco = banco;
  }

  public Set<Usuario> getUsuarios() {
    return usuarios;
  }

  public void setUsuarios(Set<Usuario> usuarios) {
    this.usuarios = usuarios;
  }
}
