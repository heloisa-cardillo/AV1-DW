package com.autobots.automanager.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.modelo.EnderecoAtualizador;
import com.autobots.automanager.repositorios.ClienteRepositorio;
import com.autobots.automanager.repositorios.EnderecoRepositorio;

@Service
public class EnderecoServico {

    @Autowired
    private EnderecoRepositorio repositorio;

    @Autowired
    private ClienteRepositorio clienteRepositorio;

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
        List<Cliente> clientes = clienteRepositorio.findAll();
        for (Cliente cliente : clientes) {
            if (endereco.equals(cliente.getEndereco())) {
                cliente.setEndereco(null);
            }
        }
        clienteRepositorio.saveAll(clientes);
        repositorio.delete(endereco);
    }
}
