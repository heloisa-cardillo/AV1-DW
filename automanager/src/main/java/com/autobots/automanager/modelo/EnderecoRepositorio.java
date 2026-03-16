package com.autobots.automanager.modelo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.autobots.automanager.entidades.Endereco;

public interface EnderecoRepositorio extends JpaRepository<Endereco, Long> {
}