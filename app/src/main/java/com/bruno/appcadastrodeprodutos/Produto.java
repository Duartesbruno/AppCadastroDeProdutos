package com.bruno.appcadastrodeprodutos;


public class Produto {

    private int id;
    private String nome, quantidade, preco;
    private Conservacao conservacao;

    public Produto() {

    }


    public Produto(String nome, String quantidade, String preco, Conservacao conservacao) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.conservacao = conservacao;
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

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public Conservacao getConservacao() {
        return conservacao;
    }

    public void setConservacao(Conservacao conservacao) {
        this.conservacao = conservacao;
    }

    @Override
    public String toString() {
        return "Item: " + nome + "  ----  " +
                "Qt: " + quantidade +  "\n" +
                "P(un): " + preco + "  ----  " +
                "Conserv: " + conservacao;
    }

}
