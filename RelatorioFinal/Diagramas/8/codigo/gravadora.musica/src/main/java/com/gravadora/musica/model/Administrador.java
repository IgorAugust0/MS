package com.gravadora.musica.model;

public class Administrador extends Pessoa{

    public Administrador() {
    }

    public Administrador(String nome, String cpf, String telefone, String celular, String email, Endereco endereco) {
        super(nome, cpf, telefone, celular, email, endereco);
    }
    
}
