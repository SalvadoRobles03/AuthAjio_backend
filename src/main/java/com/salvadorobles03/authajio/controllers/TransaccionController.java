package com.salvadorobles03.authajio.controllers;

import com.salvadorobles03.authajio.entities.Transaccion;
import com.salvadorobles03.authajio.services.TransaccionService;
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
@RequestMapping("/transacciones")
public class TransaccionController {

  @Autowired TransaccionService transaccionService;

  @GetMapping(value = "", produces = "application/json")
  public ResponseEntity<List<Transaccion>> getAllTransaccions() {
    return ResponseEntity.ok(transaccionService.getAllTransaccions());
  }

  @GetMapping(value = "/{id}", produces = "application/json")
  public ResponseEntity<Transaccion> getTransaccionById(@PathVariable Integer id) {
    return ResponseEntity.ok(transaccionService.getTransaccionById(id).get());
  }

  @PostMapping(value = "", produces = "application/json")
  public ResponseEntity<Transaccion> createTransaccion(@RequestBody Transaccion transaccion) {
    Transaccion savedTransaccion = transaccionService.saveTransaccion(transaccion);
    return new ResponseEntity<>(savedTransaccion, HttpStatus.CREATED);
  }

  @DeleteMapping(value = "/{id}", produces = "application/json")
  public ResponseEntity<Void> deleteTransaccionById(int id) {
    transaccionService.deleteTransaccionById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
