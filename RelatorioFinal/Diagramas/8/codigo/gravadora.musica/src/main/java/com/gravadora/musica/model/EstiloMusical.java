package com.gravadora.musica.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class EstiloMusical {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String descricao;

    public EstiloMusical() {
    }

    public EstiloMusical(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    // getters e setters
}
