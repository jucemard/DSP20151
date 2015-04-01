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

    public Resources res;

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

}
