package com.salvadorobles03.authajio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salvadorobles03.authajio.entities.Tarjeta;
import com.salvadorobles03.authajio.repositories.TarjetaRepository;

@Service
public class TarjetaService {

    @Autowired
    TarjetaRepository tarjetaRepository;

    public Tarjeta saveTarjeta(Tarjeta tarjeta) {
        return tarjetaRepository.save(tarjeta);
    }

    public Optional<Tarjeta> getTarjetaById(int id) {
        return tarjetaRepository.findById(id);
    }

    public List<Tarjeta> getAllTarjetas() {
        return tarjetaRepository.findAll();
    }

    public void deleteTarjetaById(int id) {
        tarjetaRepository.deleteById(id);
    }


}
