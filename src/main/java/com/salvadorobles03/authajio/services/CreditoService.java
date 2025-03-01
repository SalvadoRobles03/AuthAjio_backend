package com.salvadorobles03.authajio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salvadorobles03.authajio.entities.Credito;
import com.salvadorobles03.authajio.repositories.CreditoRepository;

@Service
public class CreditoService {

    @Autowired
    CreditoRepository creditoRepository;

    public Credito saveCredito(Credito credito) {
        return creditoRepository.save(credito);
    }

    public Optional<Credito> getCreditoById(int id) {
        return creditoRepository.findById(id);
    }

    public List<Credito> getAllCreditos() {
        return creditoRepository.findAll();
    }

    public void deleteCreditoById(int id) {
        creditoRepository.deleteById(id);
    }


}
