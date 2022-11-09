package com.example.geomontt;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RegistroUsuarios extends AppCompatActivity implements View.OnClickListener{
Button btnEditar, btnEliminar, btnMostrar,  btnSalir;
TextView nombre;
int id=0;
Usuario u;
daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);
        nombre=(TextView)findViewById(R.id.nombreUsuario);
        btnEditar=(Button)findViewById(R.id.btnEditar);
        btnMostrar=(Button)findViewById(R.id.btnMostrar);
        btnEliminar=(Button)findViewById(R.id.btnEliminar);
        btnSalir=(Button)findViewById(R.id.btnSalir);
        btnEditar.setOnClickListener(this);
        btnMostrar.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);
        btnSalir.setOnClickListener(this);

        Bundle b= getIntent().getExtras();
        id =b.getInt("id");
        dao = new daoUsuario(this);
        u=dao.getUsuarioById(id);
        nombre.setText(u.getNombre()+" " + u.getApellidos());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnEditar:
                Intent i = new Intent(this, EditarPerfil.class);
                i.putExtra("id", id);
                startActivity(i);
                finish();
                break;
            case R.id.btnEliminar:
                AlertDialog.Builder b = new AlertDialog.Builder(this);
                b.setMessage("¿Estas seguro de que deseas eliminar tu cuenta?");
                b.setCancelable(false);
                b.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(dao.deleteUsuario(id)){
                            Toast.makeText(RegistroUsuarios.this, "Se elimino correctamente", Toast.LENGTH_LONG).show();
                            Intent a = new Intent(RegistroUsuarios.this, MainActivity.class);
                            startActivity(a);
                            finish();
                        }else{
                            Toast.makeText(RegistroUsuarios.this, "No se elimino la cuenta", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                b.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                b.show();
                break;
            case R.id.btnMostrar:
                Intent i3 = new Intent(this, mostrar.class);
                startActivity(i3);
                finish();
                break;
            case R.id.btnSalir:
                Intent i4 = new Intent(this, Menu.class);
                startActivity(i4);
                finish();
                break;

        }
    }
}