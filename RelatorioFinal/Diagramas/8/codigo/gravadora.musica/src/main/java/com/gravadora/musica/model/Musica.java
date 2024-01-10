package com.gravadora.musica.model;

import java.util.List;
import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Musica {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long id_estiloMusical;

    @Column
    private String nome;

    @Column
    private String duracao;

    @Column
    private String data_Criacao;

    @Column
    private List<Musico> autores_letra;

    @Column
    private List<Musico> autores_musica;

    @Column
    private List<Instrumento> instrumentos;

    @Column
    private Musico produtor;

    @Column
    private Map<Long, Long> musicoQueGravou;

    @Column
    private Long id_banda;
    
    public Musica() {
}

    public Musica(Long id_estiloMusical, String nome, String duracao, String data_Criacao, List<Musico> autores_letra, List<Musico> autores_musica, List<Instrumento> intrumentos, Musico produtor, Map<Long, Long> musicoQueGravou, Long id_banda) {
        this.id_estiloMusical = id_estiloMusical;
        this.nome = nome;
        this.duracao = duracao;
        this.data_Criacao = data_Criacao;
        this.autores_letra = autores_letra;
        this.autores_musica = autores_musica;
        this.instrumentos = intrumentos;
        this.produtor = produtor;
        this.musicoQueGravou = musicoQueGravou;
        this.id_banda = id_banda;
    }

    // getters e setters

    public Musica(Long id_estiloMusical2, String nome2, String duracao2, String data_Criacao2,
            List<Musico> autores_letra2, List<Musico> autores_musica2, List<Instrumento> instrumentos2,
            String produtor2, Map<Long, Long> musicoQueGravou2, String id_banda2) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void adicionarMusicoQueGravou(Long idMusico, Long idInstrumento) {
        this.musicoQueGravou.put(idMusico, idInstrumento);
    }
}
