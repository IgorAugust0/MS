package com.gravadora.musica.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_album;

    @Column
    private String titulo;

    @Column
    private String cod_album;

    @Column
    private String data_lancamento;

    @Column
    private String formato;

    @Column
    private Musico produtor;

    @Column
    private Long id_banda;

    @Column
    private List<Musica> musicas;

    @Column
    private boolean finalizado;

    public Album() {
    }

    public Album(String titulo, String cod_album, String data_lancamento, String formato, Musico produtor, Long id_banda, List<Musica> musicas) {
        this.titulo = titulo;
        this.cod_album = cod_album;
        this.data_lancamento = data_lancamento;
        this.formato = formato;
        this.produtor = produtor;
        this.id_banda = id_banda;
        this.musicas = musicas;
        this.finalizado = false;
    }

    // getters e setters

}
