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

import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.servicos.DocumentoServico;

@RestController
@RequestMapping("/documento")
public class DocumentoControle {

    @Autowired
    private DocumentoServico servico;

    @GetMapping("/documento/{id}")
    public Documento obterDocumento(@PathVariable long id) {
        return servico.obterDocumento(id);
    }

    @GetMapping
    public List<Documento> obterDocumentos() {
        return servico.obterDocumentos();
    }

    @PostMapping("/cadastro")
    public void cadastrarDocumento(@RequestBody Documento documento) {
        servico.cadastrarDocumento(documento);
    }

    @PutMapping("/atualizar")
    public void atualizarDocumento(@RequestBody Documento atualizacao) {
        servico.atualizarDocumento(atualizacao);
    }

    @DeleteMapping("/excluir")
    public void excluirDocumento(@RequestBody Documento exclusao) {
        servico.excluirDocumento(exclusao);
    }
}