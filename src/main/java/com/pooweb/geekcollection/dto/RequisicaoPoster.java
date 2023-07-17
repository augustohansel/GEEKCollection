package com.pooweb.geekcollection.dto;

import com.pooweb.geekcollection.models.Poster;

import java.math.BigDecimal;

public class RequisicaoPoster {
    private String nome;
    private BigDecimal base;
    private BigDecimal altura;
    private String universo;

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

    public Poster toPoster(){
        Poster poster = new Poster();
        poster.setNome(this.nome);
        poster.setBase(this.base);
        poster.setAltura(this.altura);
        poster.setUniverso(this.universo);

        return poster;
    }

    @Override
    public String toString() {
        return "RequisicaoActionFigure{" +
                "nome='" + nome + '\'' +
                ", base=" + base +
                ", altura=" + altura +
                ", universo='" + universo + '\'' +
                '}';
    }

    public Poster toPoster(Poster poster){
        poster.setNome(this.nome);
        poster.setBase(this.base);
        poster.setAltura(this.altura);
        poster.setUniverso(this.universo);
        return poster;
    }

}


