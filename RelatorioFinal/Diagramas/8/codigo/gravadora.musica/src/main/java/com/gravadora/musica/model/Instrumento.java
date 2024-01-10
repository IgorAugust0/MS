package com.gravadora.musica.model;
import jakarta.persistence.*;

public class Instrumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String modelo;

    @Column
    private String marca;

    @Column
    private String tom_musical;

    @Column
    private boolean emUso;

    public Instrumento() {
    }

    public Instrumento(Long id, String nome, String modelo, String marca, String tom_musical) {
        this.id = id;
        this.nome = nome;
        this.modelo = modelo;
        this.marca = marca;
        this.tom_musical = tom_musical;
        this.emUso = false;
    }

    // getters e setters
    
}
