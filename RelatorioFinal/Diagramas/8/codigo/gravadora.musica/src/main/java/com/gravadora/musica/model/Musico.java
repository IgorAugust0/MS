package com.gravadora.musica.model;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

public class Musico extends Pessoa{

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_pessoa")
    private List<Long> instrumentos;

    public Musico() {
    }

    public Musico(String nome, String cpf, String telefone, String celular, String email, Endereco endereco) {
        super(nome, cpf, telefone, celular, email, endereco);        
        this.instrumentos = new ArrayList<Long>();
    }

    public List<Long> getInstrumentos() {
        return instrumentos;
    }

    public void addInstrumento(Long instrumento) {
        this.instrumentos.add(instrumento);
    }

    public void removeInstrumento(Long instrumento) {
        this.instrumentos.remove(instrumento);
    }
    
}
