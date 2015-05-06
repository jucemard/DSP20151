package br.grupointegrado.projetoleadsandroidannotations.dao;

import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bhpachulski on 5/4/2015.
 */
public abstract class DAOImpl<T> implements DAO<T> {

    private static final String SD_PATH = Environment.getExternalStorageDirectory()
            .getAbsolutePath();
    private static final String DB_NAME = "BaseLeads.db";

    private SQLiteDatabase connection;

    private Class<T> type;

    public DAOImpl (Class<T> type) {
        connection = SQLiteDatabase.openDatabase(SD_PATH + File.separator + DB_NAME,
                null, SQLiteDatabase.OPEN_READWRITE);

        this.type = type;
    }

    public SQLiteDatabase getConnection() {
        return connection;
    }

    public void setConnection(SQLiteDatabase connection) {
        this.connection = connection;
    }

    @Override
    public String getTableName() {
        return type.getName();
    }

    @Override
    public String[] getAllFields() {
        List<String> fields = new ArrayList<>();
        for (Field f : type.getDeclaredFields()) {
           fields.add(f.getName());
        }

        return fields.toArray(new String[fields.size()]);
    }
}
