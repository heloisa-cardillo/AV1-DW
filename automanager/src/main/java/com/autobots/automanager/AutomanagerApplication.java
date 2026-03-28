package com.autobots.automanager;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.repositorios.ClienteRepositorio;

@SpringBootApplication
public class AutomanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomanagerApplication.class, args);
	}

	@Component
	public static class Runner implements ApplicationRunner {
		@Autowired
		public ClienteRepositorio repositorio;

		@Override
		public void run(ApplicationArguments args) throws Exception {
			if (repositorio.count() > 0) {
				return;
			}

			// TESTE cliente 1
			Cliente cliente = new Cliente();
			cliente.setNome("José Ricardo");
			cliente.setNomeSocial("O Coelho Ousado");
			cliente.setDataCadastro(new java.util.Date(2024 - 1900, 2, 11));
			Calendar nascimentoCliente = Calendar.getInstance();
			nascimentoCliente.set(1990, 4, 15);
			cliente.setDataNascimento(nascimentoCliente.getTime());

			Telefone telefone = new Telefone();
			telefone.setDdd("12");
			telefone.setNumero("9981828356");
			cliente.getTelefones().add(telefone);

			Endereco endereco = new Endereco();
			endereco.setRua("Avenida Engenheiro José Longo");
			endereco.setBairro("São Dimas");
			endereco.setCidade("São José dos Campos");
			endereco.setEstado("SP");
			endereco.setNumero("");
			endereco.setCodigoPostal("12245-000");
			cliente.setEndereco(endereco);

			Documento documento = new Documento();
			documento.setTipo("RG");
			documento.setNumero("9981828356");
			cliente.getDocumentos().add(documento);

			repositorio.save(cliente);

			// TESTE cliente 2
			Cliente danielle = new Cliente();
			danielle.setNome("Danielle");
			danielle.setNomeSocial("A Coelha Carinhosa");
			danielle.setDataCadastro(new java.util.Date(2024 - 1900, 2, 11));
			Calendar nascimentoDanielle = Calendar.getInstance();
			nascimentoDanielle.set(1992, 7, 23);
			danielle.setDataNascimento(nascimentoDanielle.getTime());

			Telefone telefoneDanielle = new Telefone();
			telefoneDanielle.setDdd("12");
			telefoneDanielle.setNumero("9981828356");
			danielle.getTelefones().add(telefoneDanielle);

			Endereco enderecoDanielle = new Endereco();
			enderecoDanielle.setRua("Avenida Engenheiro José Longo");
			enderecoDanielle.setBairro("São Dimas");
			enderecoDanielle.setCidade("São José dos Campos");
			enderecoDanielle.setEstado("SP");
			enderecoDanielle.setNumero("");
			enderecoDanielle.setCodigoPostal("12245-000");
			danielle.setEndereco(enderecoDanielle);

			Documento documentoDanielle = new Documento();
			documentoDanielle.setTipo("RG");
			documentoDanielle.setNumero("00000000001");
			danielle.getDocumentos().add(documentoDanielle);

			repositorio.save(danielle);
		}
	}

}