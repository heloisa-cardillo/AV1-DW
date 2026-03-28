package com.autobots.automanager.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.modelo.DocumentoAtualizador;
import com.autobots.automanager.repositorios.DocumentoRepositorio;

@Service
public class DocumentoServico {

    @Autowired
    private DocumentoRepositorio repositorio;

    public Documento obterDocumento(long id) {
        return repositorio.findById(id).orElse(null);
    }

    public List<Documento> obterDocumentos() {
        return repositorio.findAll();
    }

    public void cadastrarDocumento(Documento documento) {
        repositorio.save(documento);
    }

    public void atualizarDocumento(Documento atualizacao) {
        Documento documento = repositorio.findById(atualizacao.getId()).orElse(null);
        DocumentoAtualizador atualizador = new DocumentoAtualizador();
        atualizador.atualizar(documento, atualizacao);
        repositorio.save(documento);
    }

    public void excluirDocumento(Documento exclusao) {
        Documento documento = repositorio.findById(exclusao.getId()).orElse(null);
        repositorio.delete(documento);
    }
}