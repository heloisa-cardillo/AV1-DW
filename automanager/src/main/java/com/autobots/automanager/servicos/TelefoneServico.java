package com.autobots.automanager.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.modelo.TelefoneAtualizador;
import com.autobots.automanager.repositorios.TelefoneRepositorio;

@Service
public class TelefoneServico {

    @Autowired
    private TelefoneRepositorio repositorio;

    public Telefone obterTelefone(long id) {
        return repositorio.findById(id).orElse(null);
    }

    public List<Telefone> obterTelefones() {
        return repositorio.findAll();
    }

    public void cadastrarTelefone(Telefone telefone) {
        repositorio.save(telefone);
    }

    public void atualizarTelefone(Telefone atualizacao) {
        Telefone telefone = repositorio.findById(atualizacao.getId()).orElse(null);
        TelefoneAtualizador atualizador = new TelefoneAtualizador();
        atualizador.atualizar(telefone, atualizacao);
        repositorio.save(telefone);
    }

    public void excluirTelefone(Telefone exclusao) {
        Telefone telefone = repositorio.findById(exclusao.getId()).orElse(null);
        repositorio.delete(telefone);
    }
}