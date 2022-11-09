package com.example.geomontt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditarPerfil extends AppCompatActivity implements View.OnClickListener {
EditText ediUser,ediPas,ediNombre,ediApellido;
Button btnActualizar, btnCancelar;
int id=0;
Usuario u;
daoUsuario dao;
Intent x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);
        ediUser = (EditText) findViewById(R.id.ediUser);
        ediPas = (EditText) findViewById(R.id.ediPas);
        ediNombre = (EditText) findViewById(R.id.ediNombre);
        ediApellido = (EditText) findViewById(R.id.ediApellido);
        btnActualizar=(Button) findViewById(R.id.btnEdiActualizar);
        btnCancelar=(Button) findViewById(R.id.btnEdiCancel);

        btnActualizar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);


        Bundle b= getIntent().getExtras();
        id =b.getInt("id");
        dao = new daoUsuario(this);
        u=dao.getUsuarioById(id);
        ediUser.setText(u.getUsuario());
        ediPas.setText(u.getPassword());
        ediNombre.setText(u.getNombre());
        ediApellido.setText(u.getApellidos());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnEdiActualizar:
                u.setUsuario(ediUser.getText().toString());
                u.setPassword(ediPas.getText().toString());
                u.setNombre(ediNombre.getText().toString());
                u.setApellidos(ediApellido.getText().toString());
                if(!u.isNull()){
                    Toast.makeText(this, "ERROR; CAMPOS VACIOS", Toast.LENGTH_LONG).show();
                }else if (dao.updateUsuario(u)){
                    Toast.makeText(this, "Actualizado Exitosamente", Toast.LENGTH_LONG).show();
                    Intent i2 = new Intent(this, RegistroUsuarios.class);
                    i2.putExtra("id", u.getId());
                    startActivity(i2);
                    finish();
                }else{
                    Toast.makeText(this, "No se puede actualizar", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.btnEdiCancel:
                Intent i4 = new Intent(this, RegistroUsuarios.class);
                i4.putExtra("id", u.getId());
                startActivity(i4);
                finish();
                break;

        }
    }
}