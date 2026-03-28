package com.autobots.automanager.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.modelo.EnderecoAtualizador;
import com.autobots.automanager.repositorios.EnderecoRepositorio;

@Service
public class EnderecoServico {

    @Autowired
    private EnderecoRepositorio repositorio;

    public Endereco obterEndereco(long id) {
        return repositorio.findById(id).orElse(null);
    }

    public List<Endereco> obterEnderecos() {
        return repositorio.findAll();
    }

    public void cadastrarEndereco(Endereco endereco) {
        repositorio.save(endereco);
    }

    public void atualizarEndereco(Endereco atualizacao) {
        Endereco endereco = repositorio.findById(atualizacao.getId()).orElse(null);
        EnderecoAtualizador atualizador = new EnderecoAtualizador();
        atualizador.atualizar(endereco, atualizacao);
        repositorio.save(endereco);
    }

    public void excluirEndereco(Endereco exclusao) {
        Endereco endereco = repositorio.findById(exclusao.getId()).orElse(null);
        repositorio.delete(endereco);
    }
}