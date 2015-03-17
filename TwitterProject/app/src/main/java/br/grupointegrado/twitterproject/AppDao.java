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

        String SQL_CREATE_CONTA = "CREATE  TABLE Conta ( " +
                                    "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                                    "NOME VARCHAR(50) NOT NULL, " +
                                    "CONTA VARCHAR(20) NOT NULL " +
                                   ");";

        getWritableDatabase().execSQL(SQL_CREATE_CONTA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
