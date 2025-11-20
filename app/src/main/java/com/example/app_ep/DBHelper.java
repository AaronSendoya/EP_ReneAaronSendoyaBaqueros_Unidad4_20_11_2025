package com.example.app_ep;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "empresas.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_EMPRESA = "Empresas";
    public static final String COLUMN_ID_EMPRESA = "IdEmpresa";
    public static final String COLUMN_NOMBRE = "Nombre";
    public static final String COLUMN_TELEFONO = "Telfono";
    public static final String COLUMN_DOMICILIO = "Domicilio";
    public static final String COLUMN_OBSERVACIONES = "Observaciones";
    public static final String COLUMN_CONTACTO = "Contacto";
    public static final String COLUMN_ABREVIATURA = "Abreviatura";


    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_EMPRESA + " (" +
                    COLUMN_ID_EMPRESA + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NOMBRE + " TEXT, " +
                    COLUMN_TELEFONO + " INTEGER, " +
                    COLUMN_DOMICILIO + " TEXT, " +
                    COLUMN_OBSERVACIONES + " TEXT, " +
                    COLUMN_CONTACTO + " TEXT, " +
                    COLUMN_ABREVIATURA + " TEXT " +
                    ");";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPRESA);
        onCreate(db);
    }
}

