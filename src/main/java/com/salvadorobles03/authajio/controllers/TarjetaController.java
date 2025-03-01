package com.salvadorobles03.authajio.controllers;

import com.salvadorobles03.authajio.entities.Tarjeta;
import com.salvadorobles03.authajio.services.TarjetaService;
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
@RequestMapping("/tarjetas")
public class TarjetaController {

  @Autowired TarjetaService tarjetaService;

  @GetMapping(value = "", produces = "application/json")
  public ResponseEntity<List<Tarjeta>> getAllTarjetas() {
    return ResponseEntity.ok(tarjetaService.getAllTarjetas());
  }

  @GetMapping(value = "/{id}", produces = "application/json")
  public ResponseEntity<Tarjeta> getTarjetaById(@PathVariable Integer id) {
    return ResponseEntity.ok(tarjetaService.getTarjetaById(id).get());
  }

  @PostMapping(value = "", produces = "application/json")
  public ResponseEntity<Tarjeta> createTarjeta(@RequestBody Tarjeta tarjeta) {
    Tarjeta savedTarjeta = tarjetaService.saveTarjeta(tarjeta);
    return new ResponseEntity<>(savedTarjeta, HttpStatus.CREATED);
  }

  @DeleteMapping(value = "/{id}", produces = "application/json")
  public ResponseEntity<Void> deleteTarjetaById(int id) {
    tarjetaService.deleteTarjetaById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
