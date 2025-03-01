package com.salvadorobles03.authajio.controllers;

import com.salvadorobles03.authajio.entities.Usuario;
import com.salvadorobles03.authajio.services.UsuarioService;
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
@RequestMapping("/usuarios")
public class UsuarioController {

  @Autowired UsuarioService usuarioService;

  @GetMapping(value = "", produces = "application/json")
  public ResponseEntity<List<Usuario>> getAllUsuarios() {
    return ResponseEntity.ok(usuarioService.getAllUsuarios());
  }

  @GetMapping(value = "/{id}", produces = "application/json")
  public ResponseEntity<Usuario> getUsuarioById(@PathVariable Integer id) {
    return ResponseEntity.ok(usuarioService.getUsuarioById(id).get());
  }

  @PostMapping(value = "", produces = "application/json")
  public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
    Usuario savedUsuario = usuarioService.saveUsuario(usuario);
    return new ResponseEntity<>(savedUsuario, HttpStatus.CREATED);
  }

  @DeleteMapping(value = "/{id}", produces = "application/json")
  public ResponseEntity<Void> deleteUsuarioById(int id) {
    usuarioService.deleteUsuarioById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
