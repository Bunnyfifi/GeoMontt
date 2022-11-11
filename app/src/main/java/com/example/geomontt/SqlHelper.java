package com.example.geomontt;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqlHelper extends SQLiteOpenHelper {
    static String nombre="mapa";
    static int version = 1;


    public SqlHelper(@Nullable Context context) {
        super(context, nombre, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String marcador = "create table marcador (titulo text primary key, latitud decimal (10,8), longitud decimal (10,8))";
        sqLiteDatabase.execSQL(marcador);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
