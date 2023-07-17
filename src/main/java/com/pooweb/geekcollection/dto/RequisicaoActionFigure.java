package com.pooweb.geekcollection.dto;

import com.pooweb.geekcollection.models.ActionFigure;

import java.math.BigDecimal;

public class RequisicaoActionFigure {

    private String nome;
    private BigDecimal altura;
    private String universo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public ActionFigure toActionFigure(){
        ActionFigure actionfigure = new ActionFigure();
        actionfigure.setNome(this.nome);
        actionfigure.setAltura(this.altura);
        actionfigure.setUniverso(this.universo);

        return actionfigure;
    }

    @Override
    public String toString() {
        return "RequisicaoNovaActionFigure{" +
                "nome='" + nome + '\'' +
                ", altura=" + altura +
                ", universo='" + universo + '\'' +
                '}';
    }

    public ActionFigure toActionFigure(ActionFigure actionFigure){
        actionFigure.setNome(this.nome);
        actionFigure.setAltura(this.altura);
        actionFigure.setUniverso(this.universo);
        return actionFigure;
    }
}
