package br.grupointegrado.twitterproject;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bhpachulski on 3/16/2015.
 */
public class AppDao extends SQLiteOpenHelper {

    private static final String BD_NAME = "TwitterProjectBD";
    private static final int BD_VERSION = 1;
    private static final String[] TB_COLUMNS = new String[]{"id", "NOME", "CONTA"};
    private static final String TB_NAME = "Conta";
    private Resources res;

    public AppDao(Context context) {
        super(context, AppDao.BD_NAME, null, AppDao.BD_VERSION);
        res = context.getResources();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Executa o SQL
        db.execSQL(res.getString(R.string.SQL_CREATE_CONTATO));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    public void saveConta (Conta c) {
        ContentValues cv = new ContentValues();
        cv.put("NOME", c.getNome());
        cv.put("CONTA", c.getConta());

        getWritableDatabase().insert(TB_NAME, null, cv);
    }

    public List<Conta> listConta () {
        Cursor c = getReadableDatabase().query(TB_NAME, TB_COLUMNS,
                null, null, null, null, null);

        List<Conta> contas = new ArrayList<>();

        while (c.moveToNext()) {
            contas.add(new Conta(c.getInt(c.getColumnIndex("id")), c.getString(c.getColumnIndex("NOME")), c.getString(2)));
        }

        c.close();

        return contas;
    }

    public boolean verificaUsuario (String user, String pass) {
        Cursor query = getReadableDatabase().rawQuery("SELECT * FROM ? WHERE USER = ? AND PASS = ?",
                new String[]{TB_NAME, user, pass});

        if (query.getCount() == 1)
            return true;
        else
            return false;

    }

    public void deleteConta (Conta c) {
        getWritableDatabase().delete(TB_NAME, "id = ?", new String[]{c.getId().toString()});
    }

    public void updateConta (Conta c) {
        ContentValues cv = new ContentValues();
        cv.put("NOME", c.getNome());
        cv.put("CONTA", c.getConta());

        getWritableDatabase().update(TB_NAME, cv, "id = ?", new String[]{c.getId().toString()});
    }

}
