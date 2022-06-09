package com.example.asus.proyectodeciclo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDeDatos extends SQLiteOpenHelper {

String crear="CREATE TABLE posiciones(NM TEXT, PJ INTEGER, PG INTEGER, PE INTEGER, PP INTEGER, GF INTEGER, GC INTEGER, DG INTEGER, PT INTEGER)";
String borrar="DROP TABLE IF EXISTS posiciones";

    public BaseDeDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

       db.execSQL(crear);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(borrar);
        db.execSQL(crear);

    }
}
