package br.grupointegrado.twitterproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bhpachulski on 3/31/2015.
 */
public class ContaDao extends AppDao {

    private static final String[] TB_COLUMNS = new String[]{"id", "NOME", "CONTA"};
    private static final String TB_NAME = "Conta";

    public ContaDao (Context c) {
        super(c);
    }

    public void save(Conta c) {
        ContentValues cv = new ContentValues();
        cv.put("NOME", c.getNome());
        cv.put("CONTA", c.getConta());

        getWritableDatabase().insert(TB_NAME, null, cv);
    }

    public List<Conta> list() {
        Cursor c = getReadableDatabase().query(TB_NAME, TB_COLUMNS,
                null, null, null, null, null);

        List<Conta> contas = new ArrayList<>();

        while (c.moveToNext()) {
            contas.add(new Conta(c.getInt(c.getColumnIndex("id")), c.getString(c.getColumnIndex("NOME")), c.getString(2)));
        }

        c.close();

        return contas;
    }

    public void delete(Conta c) {
        getWritableDatabase().delete(TB_NAME, "id = ?", new String[]{c.getId().toString()});
    }

    public void update(Conta c) {
        ContentValues cv = new ContentValues();
        cv.put("NOME", c.getNome());
        cv.put("CONTA", c.getConta());

        getWritableDatabase().update(TB_NAME, cv, "id = ?", new String[]{c.getId().toString()});
    }

}
