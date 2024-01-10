package com.gravadora.musica.service;
import org.springframework.beans.factory.annotation.Autowired;
import com.gravadora.musica.model.Administrador;
import com.gravadora.musica.model.Endereco;
import com.gravadora.musica.model.Musico;
import com.gravadora.musica.repository.AdministradorRepository;

public class AdministradorService {
    @Autowired
    private AdministradorRepository administradorRepository;

    public String cadastrarPessoa(String nome, String cpf, String telefone, String celular, 
        String email, Endereco endereco, String tipo) {

        try {
            // verifica se a pessoa ja existe no banco de dados
            Administrador administradorExistente = administradorRepository.findByCpf(cpf);

            // se a pessoa ja existe, lanca uma excecao
            if (administradorExistente != null) {
                throw new RuntimeException("Pessoa já existe");
            }

            // verifica o tipo de pessoa
            if (tipo.equals("administrador")) {

                // Cria a instancia de Administrador
                Administrador administrador = new Administrador(nome, cpf, telefone, celular, email, endereco);

                // Salva o administrador no banco de dados
                administradorRepository.saveAdministrador(administrador.getId(), administrador.getNome(), 
                    administrador.getCpf(), administrador.getTelefone(), administrador.getCelular(), 
                        administrador.getEmail(), administrador.getEndereco());

            } else if (tipo.equals("musico")) {
                // Salva o musico no banco de dados
                Musico musico = new Musico(nome, cpf, telefone, celular, email, endereco);
                administradorRepository.saveMusico(musico.getId(), musico.getNome(), musico.getCpf(), 
                    musico.getTelefone(), musico.getCelular(), musico.getEmail(), musico.getEndereco());
            }

            return "Sucesso";
        } catch (RuntimeException e) {
            return "Erro: " + e.getMessage();
        } catch (Exception e) {
            return "Erro no banco de dados: " + e.getMessage();
        }
    }



    
    public void cadastrarPessoa2(String nome, String cpf, String telefone, String celular, String email, Endereco endereco, String tipo) {

        // verifica se a pessoa ja existe no banco de dados
        Administrador administradorExistente = administradorRepository.findByCpf(cpf);

        // se a pessoa ja existe, lanca uma excecao
        if (administradorExistente != null) {
            throw new RuntimeException("Pessoa já existe");
        }

        // Check the tipo of pessoa
        if (tipo.equals("administrador")) {

            // Cria a instancia de Administrador
            Administrador administrador = new Administrador(nome, cpf, telefone, celular, email, endereco);

            // Salva o administrador no banco de dados
            administradorRepository.saveAdministrador(administrador.getId(), administrador.getNome(), administrador.getCpf(), administrador.getTelefone(), administrador.getCelular(), administrador.getEmail(), administrador.getEndereco());

        } else if (tipo.equals("musico")) {
            // Save pessoa in the database and associate endereco with pessoa
            Musico musico = new Musico(nome, cpf, telefone, celular, email, endereco);
            administradorRepository.saveMusico(musico.getId(), musico.getNome(), musico.getCpf(), musico.getTelefone(), musico.getCelular(), musico.getEmail(), musico.getEndereco());
        }
    }



}
