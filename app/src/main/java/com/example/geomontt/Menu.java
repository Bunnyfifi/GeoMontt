package com.example.geomontt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Menu extends AppCompatActivity implements View.OnClickListener{
Button btnMapa, btnMonumentos, btnEditar, btnUsuarios, btnSalir;
TextView nombre;
int id=0;
Usuario u;
daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        nombre=(TextView)findViewById(R.id.nombreUsuario);
        btnMapa = (Button)findViewById(R.id.btnMenuMapa);
        btnMonumentos = (Button)findViewById(R.id.btnMenuMonumentos);
        btnEditar = (Button)findViewById(R.id.btnMenuEditarPerfil);
        btnUsuarios = (Button)findViewById(R.id.btnMenuUsuarios);
        btnSalir = (Button)findViewById(R.id.btnMenuSalir);

        btnMapa.setOnClickListener(this);
        btnMonumentos.setOnClickListener(this);
        btnEditar.setOnClickListener(this);
        btnUsuarios.setOnClickListener(this);
        btnSalir.setOnClickListener(this);
        Bundle b= getIntent().getExtras();
        id = b.getInt("id");
        dao = new daoUsuario(this);
        u=dao.getUsuarioById(id);
        nombre.setText(u.getNombre()+" " + u.getApellidos());

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnMenuEditarPerfil:

                Intent i = new Intent(this, EditarPerfil.class);
                i.putExtra("id", id);
                startActivity(i);
                finish();
                break;
            case R.id.btnMenuMapa:
                Intent i2 = new Intent(this, Mapa.class);
                startActivity(i2);
                finish();
                break;
            case R.id.btnMenuMonumentos:
                Intent i3 = new Intent(this, ListaMonumentos.class);
                startActivity(i3);
                finish();
                break;
            case R.id.btnMenuUsuarios:
                Intent i4 = new Intent(this, RegistroUsuarios.class);
                startActivity(i4);
                finish();
                break;
            case R.id.btnMenuSalir:
                Intent i5 = new Intent(this, MainActivity.class);
                startActivity(i5);
                finish();
                break;

        }
    }
}
