package com.pooweb.geekcollection.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
@Entity
public class Poster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String nome;
    private BigDecimal base;
    private BigDecimal altura;
    private String universo;

    public Poster() {
    }

    public Poster(String nome, BigDecimal base, BigDecimal altura, String universo) {
        this.nome = nome;
        this.base = base;
        this.altura = altura;
        this.universo = universo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getBase() {
        return base;
    }

    public void setBase(BigDecimal base) {
        this.base = base;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    public String getUniverso() {
        return universo;
    }

    public void setUniverso(String universo) {
        this.universo = universo;
    }

    @Override
    public String toString() {
        return "Poster{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", base=" + base +
                ", altura=" + altura +
                ", universo='" + universo + '\'' +
                '}';
    }
}
