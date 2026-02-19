package com.weg.MeuSegundoSpring.Model;

public class Contato {

    private int id;
    private String nome;
    private int numero;

    public Contato() {
        this.id = id;
        this.nome = nome;
        this.numero = numero;
    }

    public Contato(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
