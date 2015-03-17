package br.grupointegrado.twitterproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by bhpachulski on 3/16/2015.
 */
public class AppDao extends SQLiteOpenHelper {

    private static final String BD_NAME = "TwitterProjectBD";
    private static final int BD_VERSION = 1;

    public AppDao(Context context) {
        super(context, AppDao.BD_NAME, null, AppDao.BD_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        StringBuilder SQL_CREATE_CONTA = new StringBuilder();
        SQL_CREATE_CONTA.append("CREATE  TABLE Conta ( ");
        SQL_CREATE_CONTA.append("id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, ");
        SQL_CREATE_CONTA.append("NOME VARCHAR(50) NOT NULL, ");
        SQL_CREATE_CONTA.append("CONTA VARCHAR(20) NOT NULL );");

        //Executa o SQL
        getWritableDatabase().execSQL(SQL_CREATE_CONTA.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
