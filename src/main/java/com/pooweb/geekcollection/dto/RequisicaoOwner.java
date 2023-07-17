package com.pooweb.geekcollection.dto;

import com.pooweb.geekcollection.models.Owner;
import com.pooweb.geekcollection.models.Poster;

public class RequisicaoOwner {
    private String nome;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Owner toOwner(){
        Owner owner = new Owner();
        owner.setNome(this.nome);
        owner.setEmail(this.email);

        return owner;
    }

    @Override
    public String toString() {
        return "RequisicaoOwner{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Owner toOwner(Owner owner){
        owner.setNome(this.nome);
        owner.setEmail(this.email);

        return owner;
    }

}