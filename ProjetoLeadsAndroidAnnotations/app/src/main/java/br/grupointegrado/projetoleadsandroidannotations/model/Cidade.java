package br.grupointegrado.projetoleadsandroidannotations.model;

/**
 * Created by bhpachulski on 5/4/2015.
 */
public class Cidade {

    private Integer id;
    private String nome;
    private String estado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
