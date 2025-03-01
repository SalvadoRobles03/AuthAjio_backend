package com.salvadorobles03.authajio.controllers;

import com.salvadorobles03.authajio.entities.Banco;
import com.salvadorobles03.authajio.services.BancoService;
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
@RequestMapping("/bancos")
public class BancoController {

  @Autowired BancoService bancoService;

  @GetMapping(value = "", produces = "application/json")
  public ResponseEntity<List<Banco>> getAllBancos() {
    return ResponseEntity.ok(bancoService.getAllBancos());
  }

  @GetMapping(value = "/{id}", produces = "application/json")
  public ResponseEntity<Banco> getBancoById(@PathVariable Integer id) {
    return ResponseEntity.ok(bancoService.getBancoById(id).get());
  }

  @PostMapping(value = "", produces = "application/json")
  public ResponseEntity<Banco> createBanco(@RequestBody Banco banco) {
    Banco savedBanco = bancoService.saveBanco(banco);
    return new ResponseEntity<>(savedBanco, HttpStatus.CREATED);
  }

  @DeleteMapping(value = "/{id}", produces = "application/json")
  public ResponseEntity<Void> deleteBancoById(int id) {
    bancoService.deleteBancoById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
