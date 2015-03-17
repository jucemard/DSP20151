package br.grupointegrado.twitterproject;

import java.io.Serializable;

/**
 * Created by bhpachulski on 3/10/2015.
 */
public class Conta implements Serializable {

    private String conta;
    private String nome;

    public Conta(String conta, String nome) {
        this.conta = conta;
        this.nome = nome;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.conta;
    }
}
