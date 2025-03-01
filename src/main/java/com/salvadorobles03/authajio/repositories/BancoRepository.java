package com.salvadorobles03.authajio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salvadorobles03.authajio.entities.Banco;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Integer> {

}
