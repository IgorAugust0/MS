package com.gravadora.musica.model;
import jakarta.persistence.*;

public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String rua;
    
    @Column
    private String bairro;
    
    @Column
    private int numero;
    
    @Column
    private String cidade;
    
    @Column
    private String complemento;
    
    @Column
    private String estado;
    
    @Column
    private String cep;
    
    // getters e setters

    public Endereco() {
    }

    public Endereco(String rua, String bairro, int numero, String cidade, String complemento, String estado, String cep) {
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cidade = cidade;
        this.complemento = complemento;
        this.estado = estado;
        this.cep = cep;
    }

    // getter e setters
    public Long getId() {
        return id;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public int getNumero() {
        return numero;
    }

    public String getCidade() {
        return cidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

    public void setCep(String cep){
        this.cep = cep;
    }
    
}
