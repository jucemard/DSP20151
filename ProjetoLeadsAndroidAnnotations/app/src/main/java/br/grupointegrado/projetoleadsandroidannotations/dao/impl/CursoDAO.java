package br.grupointegrado.projetoleadsandroidannotations.dao.impl;

import java.util.List;

import br.grupointegrado.projetoleadsandroidannotations.dao.DAOImpl;
import br.grupointegrado.projetoleadsandroidannotations.model.Curso;

/**
 * Created by bhpachulski on 5/5/2015.
 */
public class CursoDAO extends DAOImpl<Curso> {

    public CursoDAO() {
        super(Curso.class);
    }

    @Override
    public void save(Curso curso) {

    }

    @Override
    public void delete(Curso curso) {

    }

    @Override
    public void update(Curso curso) {

    }

    @Override
    public List<Curso> list() {
        return null;
    }

}
