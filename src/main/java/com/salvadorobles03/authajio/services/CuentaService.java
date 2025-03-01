package com.salvadorobles03.authajio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salvadorobles03.authajio.entities.Cuenta;
import com.salvadorobles03.authajio.repositories.CuentaRepository;

@Service
public class CuentaService {

    @Autowired
    CuentaRepository cuentaRepository;

    public Cuenta saveCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public Optional<Cuenta> getCuentaById(int id) {
        return cuentaRepository.findById(id);
    }

    public List<Cuenta> getAllCuentas() {
        return cuentaRepository.findAll();
    }

    public void deleteCuentaById(int id) {
        cuentaRepository.deleteById(id);
    }


}
