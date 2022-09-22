package com.example.geomontt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void cerrarSesion(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void mapa(View view){
        Intent i = new Intent(this, Mapa.class);
        startActivity(i);
    }
}