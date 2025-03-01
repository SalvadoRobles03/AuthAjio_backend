package com.salvadorobles03.authajio.entities;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Transacciones")
public class Transaccion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(length = 6)
  private String no_referencia;

  private double monto;

  private String concepto;

  private Date fecha;

  private String tipo_transferencia;

  @ManyToOne
  @JoinColumn(name = "id_cuenta_origen")
  private Cuenta cuenta_origen;

  @ManyToOne
  @JoinColumn(name = "id_cuenta_destino")
  private Cuenta cuenta_destino;

  public Transaccion(
      String no_referencia,
      double monto,
      String concepto,
      Date fecha,
      String tipo_transferencia,
      Cuenta cuenta_origen,
      Cuenta cuenta_destino) {
    this.no_referencia = no_referencia;
    this.monto = monto;
    this.concepto = concepto;
    this.fecha = fecha;
    this.tipo_transferencia = tipo_transferencia;
    this.cuenta_origen = cuenta_origen;
    this.cuenta_destino = cuenta_destino;
  }

  public Transaccion() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNo_referencia() {
    return no_referencia;
  }

  public void setNo_referencia(String no_referencia) {
    this.no_referencia = no_referencia;
  }

  public double getMonto() {
    return monto;
  }

  public void setMonto(double monto) {
    this.monto = monto;
  }

  public String getConcepto() {
    return concepto;
  }

  public void setConcepto(String concepto) {
    this.concepto = concepto;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public String getTipo_transferencia() {
    return tipo_transferencia;
  }

  public void setTipo_transferencia(String tipo_transferencia) {
    this.tipo_transferencia = tipo_transferencia;
  }

  public Cuenta getCuenta_origen() {
    return cuenta_origen;
  }

  public void setCuenta_origen(Cuenta cuenta_origen) {
    this.cuenta_origen = cuenta_origen;
  }

  public Cuenta getCuenta_destino() {
    return cuenta_destino;
  }

  public void setCuenta_destino(Cuenta cuenta_destino) {
    this.cuenta_destino = cuenta_destino;
  }
}
