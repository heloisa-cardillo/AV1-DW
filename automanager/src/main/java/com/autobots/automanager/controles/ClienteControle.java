package com.autobots.automanager.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.servicos.ClienteServico;

@RestController
@RequestMapping("/cliente")
public class ClienteControle {

    @Autowired
    private ClienteServico servico;

    @GetMapping("/cliente/{id}")
    public Cliente obterCliente(@PathVariable long id) {
        return servico.obterCliente(id);
    }

    @GetMapping("/clientes")
    public List<Cliente> obterClientes() {
        return servico.obterClientes();
    }

    @PostMapping("/cadastro")
    public void cadastrarCliente(@RequestBody Cliente cliente) {
        servico.cadastrarCliente(cliente);
    }

    @PutMapping("/atualizar")
    public void atualizarCliente(@RequestBody Cliente atualizacao) {
        servico.atualizarCliente(atualizacao);
    }

    @DeleteMapping("/excluir")
    public void excluirCliente(@RequestBody Cliente exclusao) {
        servico.excluirCliente(exclusao);
    }
}