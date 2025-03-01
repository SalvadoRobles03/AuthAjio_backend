package com.salvadorobles03.authajio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salvadorobles03.authajio.entities.Transaccion;
import com.salvadorobles03.authajio.repositories.TransaccionRepository;

@Service
public class TransaccionService {

    @Autowired
    TransaccionRepository transaccionRepository;

    public Transaccion saveTransaccion(Transaccion transaccion) {
        return transaccionRepository.save(transaccion);
    }

    public Optional<Transaccion> getTransaccionById(int id) {
        return transaccionRepository.findById(id);
    }

    public List<Transaccion> getAllTransaccions() {
        return transaccionRepository.findAll();
    }

    public void deleteTransaccionById(int id) {
        transaccionRepository.deleteById(id);
    }


}
