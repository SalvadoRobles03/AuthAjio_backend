package com.salvadorobles03.authajio.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Tarjetas")
public class Tarjeta {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String nombre_propietario;

  @Column(length = 16)
  private String numero_tarjeta;

  @Column(length = 3)
  private String cvv;

  @Column(length = 5)
  private String fecha_vencimiento;

  @ManyToOne
  @JoinColumn(name = "id_cuenta")
  private Cuenta cuenta;

  public Tarjeta(
      String nombre_propietario,
      String numero_tarjeta,
      String cvv,
      String fecha_vencimiento,
      Cuenta cuenta) {
    this.nombre_propietario = nombre_propietario;
    this.numero_tarjeta = numero_tarjeta;
    this.cvv = cvv;
    this.fecha_vencimiento = fecha_vencimiento;
    this.cuenta = cuenta;
  }

  public Tarjeta() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombre_propietario() {
    return nombre_propietario;
  }

  public void setNombre_propietario(String nombre_propietario) {
    this.nombre_propietario = nombre_propietario;
  }

  public String getNumero_tarjeta() {
    return numero_tarjeta;
  }

  public void setNumero_tarjeta(String numero_tarjeta) {
    this.numero_tarjeta = numero_tarjeta;
  }

  public String getCvv() {
    return cvv;
  }

  public void setCvv(String cvv) {
    this.cvv = cvv;
  }

  public String getFecha_vencimiento() {
    return fecha_vencimiento;
  }

  public void setFecha_vencimiento(String fecha_vencimiento) {
    this.fecha_vencimiento = fecha_vencimiento;
  }

  public Cuenta getCuenta() {
    return cuenta;
  }

  public void setCuenta(Cuenta cuenta) {
    this.cuenta = cuenta;
  }
}
