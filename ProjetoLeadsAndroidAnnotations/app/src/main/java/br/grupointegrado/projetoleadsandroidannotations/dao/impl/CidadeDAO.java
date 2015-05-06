package br.grupointegrado.projetoleadsandroidannotations.dao.impl;

import android.content.ContentValues;
import android.database.Cursor;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.grupointegrado.projetoleadsandroidannotations.dao.DAOImpl;
import br.grupointegrado.projetoleadsandroidannotations.model.Cidade;

/**
 * Created by bhpachulski on 5/4/2015.
 */
public class CidadeDAO extends DAOImpl<Cidade> {

    public CidadeDAO() {
        super(Cidade.class);
    }

    @Override
    public void save(Cidade cidade) {
        ContentValues cv = new ContentValues();
        cv.put("nome", cidade.getNome());
        cv.put("estado", cidade.getEstado());

        getConnection().insert(getTableName(), null, cv);
    }

    @Override
    public void delete(Cidade cidade) {
        getConnection().delete(getTableName(), "id = ?", new String[]{cidade.getId().toString()});
    }

    @Override
    public void update(Cidade cidade) {
        ContentValues cv = new ContentValues();
        cv.put("nome", cidade.getNome());
        cv.put("estado", cidade.getEstado());

        getConnection().update(getTableName(), cv, "id = ?", new String[]{cidade.getId().toString()});
    }

    @Override
    public List<Cidade> list() {
        Cursor c = getConnection().rawQuery("SELECT * FROM CIDADE", getAllFields());

        List<Cidade> cidades = new ArrayList<>();

        while (c.moveToNext()) {
            Cidade cid = new Cidade();
            cid.setId(c.getInt(0));
            cid.setNome(c.getString(1));
            cid.setEstado(c.getString(2));

            cidades.add(cid);
        }

        return cidades;
    }

}
