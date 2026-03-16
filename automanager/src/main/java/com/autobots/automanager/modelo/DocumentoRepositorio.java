package com.autobots.automanager.modelo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.autobots.automanager.entidades.Documento;

public interface DocumentoRepositorio extends JpaRepository<Documento, Long> {
}