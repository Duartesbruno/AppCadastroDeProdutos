package com.bruno.appcadastrodeprodutos;

import androidx.annotation.NonNull;

public class Produto {

    private int id;
    private String nome, quantidade;

    public Produto() {

    }


    public Produto(int id, String nome, String quantidade) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
    }


    @NonNull
    @Override
    public String toString() {
        return nome + " - Qt: " + quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

}
