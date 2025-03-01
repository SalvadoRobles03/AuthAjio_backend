package com.salvadorobles03.authajio.controllers;

import com.salvadorobles03.authajio.entities.Credito;
import com.salvadorobles03.authajio.services.CreditoService;
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
@RequestMapping("/creditos")
public class CreditoController {

  @Autowired CreditoService creditoService;

  @GetMapping(value = "", produces = "application/json")
  public ResponseEntity<List<Credito>> getAllCreditos() {
    return ResponseEntity.ok(creditoService.getAllCreditos());
  }

  @GetMapping(value = "/{id}", produces = "application/json")
  public ResponseEntity<Credito> getCreditoById(@PathVariable Integer id) {
    return ResponseEntity.ok(creditoService.getCreditoById(id).get());
  }

  @PostMapping(value = "", produces = "application/json")
  public ResponseEntity<Credito> createCredito(@RequestBody Credito credito) {
    Credito savedCredito = creditoService.saveCredito(credito);
    return new ResponseEntity<>(savedCredito, HttpStatus.CREATED);
  }

  @DeleteMapping(value = "/{id}", produces = "application/json")
  public ResponseEntity<Void> deleteCreditoById(int id) {
    creditoService.deleteCreditoById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
