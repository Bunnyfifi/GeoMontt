package com.example.geomontt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity implements View.OnClickListener {
    EditText us, pas, nom, ap;
    Button reg, can;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        us = (EditText) findViewById(R.id.regUser);
        pas = (EditText) findViewById(R.id.regPas);
        nom = (EditText) findViewById(R.id.regNombre);
        ap = (EditText) findViewById(R.id.regApellido);
        reg = (Button) findViewById(R.id.btnRegRegistrar);
        can = (Button) findViewById(R.id.btnRegCancel);

        reg.setOnClickListener(this);
        can.setOnClickListener(this);
        dao = new daoUsuario(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRegRegistrar:
                Usuario u = new Usuario();
                u.setUsuario(us.getText().toString());
                u.setPassword(pas.getText().toString());
                u.setNombre(nom.getText().toString());
                u.setApellidos(ap.getText().toString());
                if(!u.isNull()){
                    Toast.makeText(this, "ERROR; CAMPOS VACIOS", Toast.LENGTH_LONG).show();
                }else if (dao.insertUsuario(u)){
                    Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_LONG).show();
                    Intent i2 = new Intent(this, Menu.class);
                    startActivity(i2);
                    finish();
                }else{
                    Toast.makeText(this, "Usuario ya registrado!", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.btnRegCancel:
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                finish();
                break;
        }
    }
}