package br.grupointegrado.projetoleadsandroidannotations.dao;

import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import java.io.File;

/**
 * Created by bhpachulski on 5/4/2015.
 */
public abstract class DAOImpl<T> implements DAO<T> {

    private static final String SD_PATH = Environment.getExternalStorageDirectory()
            .getAbsolutePath();
    private static final String DB_NAME = "BaseLeads.db";

    private SQLiteDatabase connection;

    public DAOImpl () {
        connection = SQLiteDatabase.openDatabase(SD_PATH + File.separator + DB_NAME,
                null, SQLiteDatabase.OPEN_READWRITE);
    }

    public SQLiteDatabase getConnection() {
        return connection;
    }

    public void setConnection(SQLiteDatabase connection) {
        this.connection = connection;
    }

}
