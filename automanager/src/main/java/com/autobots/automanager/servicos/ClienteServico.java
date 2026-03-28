package com.autobots.automanager.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.modelo.ClienteAtualizador;
import com.autobots.automanager.repositorios.ClienteRepositorio;
import com.autobots.automanager.utilitarios.ClienteSelecionador;

@Service
public class ClienteServico {

    @Autowired
    private ClienteRepositorio repositorio;
    @Autowired
    private ClienteSelecionador selecionador;

    public Cliente obterCliente(long id) {
        List<Cliente> clientes = repositorio.findAll();
        return selecionador.selecionar(clientes, id);
    }

    public List<Cliente> obterClientes() {
        return repositorio.findAll();
    }

    public void cadastrarCliente(Cliente cliente) {
        repositorio.save(cliente);
    }

    public void atualizarCliente(Cliente atualizacao) {
        Cliente cliente = repositorio.findById(atualizacao.getId()).orElse(null);
        ClienteAtualizador atualizador = new ClienteAtualizador();
        atualizador.atualizar(cliente, atualizacao);
        repositorio.save(cliente);
    }

    public void excluirCliente(Cliente exclusao) {
        Cliente cliente = repositorio.findById(exclusao.getId()).orElse(null);
        repositorio.delete(cliente);
    }
}
