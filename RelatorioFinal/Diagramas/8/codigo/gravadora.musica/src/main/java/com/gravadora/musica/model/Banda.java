package com.gravadora.musica.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Banda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String descricao;

    @Column
    private String data_criacao;

    @Column
    private List<Musico> musicos;

    public Banda() {
    }

    public Banda(String nome, String descricao, String data_criacao, List<Musico> musicos) {
        this.nome = nome;
        this.descricao = descricao;
        this.data_criacao = data_criacao;
        this.musicos = musicos;
    }

    // getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
