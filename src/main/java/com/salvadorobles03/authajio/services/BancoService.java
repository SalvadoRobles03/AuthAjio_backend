package com.salvadorobles03.authajio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salvadorobles03.authajio.entities.Banco;
import com.salvadorobles03.authajio.repositories.BancoRepository;

@Service
public class BancoService {

    @Autowired
    BancoRepository bancoRepository;

    public Banco saveBanco(Banco banco) {
        return bancoRepository.save(banco);
    }

    public Optional<Banco> getBancoById(int id) {
        return bancoRepository.findById(id);
    }

    public List<Banco> getAllBancos() {
        return bancoRepository.findAll();
    }

    public void deleteBancoById(int id) {
        bancoRepository.deleteById(id);
    }


}
