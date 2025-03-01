package com.salvadorobles03.authajio.controllers;

import com.salvadorobles03.authajio.entities.Cuenta;
import com.salvadorobles03.authajio.services.CuentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

  @Autowired CuentaService cuentaService;

  @GetMapping(value = "", produces = "application/json")
  public ResponseEntity<List<Cuenta>> getAllCuentas() {
    return ResponseEntity.ok(cuentaService.getAllCuentas());
  }

  @GetMapping(value = "/{id}", produces = "application/json")
  public ResponseEntity<Cuenta> getCuentaById(@PathVariable Integer id) {
    return ResponseEntity.ok(cuentaService.getCuentaById(id).get());
  }

  @PostMapping(value = "", produces = "application/json")
  public ResponseEntity<Cuenta> createCuenta(@RequestBody Cuenta cuenta) {
    Cuenta savedCuenta = cuentaService.saveCuenta(cuenta);
    return new ResponseEntity<>(savedCuenta, HttpStatus.CREATED);
  }

  @DeleteMapping(value = "/{id}", produces = "application/json")
  public ResponseEntity<Void> deleteCuentaById(int id) {
    cuentaService.deleteCuentaById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
