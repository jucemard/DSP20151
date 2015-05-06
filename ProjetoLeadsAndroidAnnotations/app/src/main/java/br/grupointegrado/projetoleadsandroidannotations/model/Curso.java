package br.grupointegrado.projetoleadsandroidannotations.model;

/**
 * Created by bhpachulski on 5/5/2015.
 */
public class Curso {

    private int id;
    private String nome;
    private boolean aberto;


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

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }
}
