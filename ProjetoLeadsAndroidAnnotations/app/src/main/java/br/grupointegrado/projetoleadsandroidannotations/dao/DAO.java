package br.grupointegrado.projetoleadsandroidannotations.dao;

import java.util.List;

/**
 * Created by bhpachulski on 5/4/2015.
 */
public interface DAO<T> {

    public void save (T t);
    public void delete (T t);
    public void update (T t);
    public List<T> list ();

}
