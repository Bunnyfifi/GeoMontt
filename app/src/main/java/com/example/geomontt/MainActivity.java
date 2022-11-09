package com.example.geomontt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
EditText user, pass;
Button btnEntrar, btnRegistrar;
daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(EditText) findViewById(R.id.User);
        pass=(EditText) findViewById(R.id.Pass);
        btnEntrar=(Button)findViewById(R.id.btnEntrar);
        btnRegistrar=(Button)findViewById(R.id.btnRegistrar);

        btnEntrar.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);
        dao=new daoUsuario(this);
    }
    /*public void menu(View view){
        Intent i = new Intent(this, Menu.class);
        startActivity(i);
    }
    public void registro(View view){
        Intent i = new Intent(this, Registro.class);
        startActivity(i);
    }*/

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnEntrar:
                String u=user.getText().toString();
                String p=pass.getText().toString();
                if(u.equals("")&&p.equals("")){
                    Toast.makeText(this, "ERROR; CAMPOS VACIOS", Toast.LENGTH_LONG).show();
                }else if(dao.login(u,p)==1){
                    Usuario ux=dao.getUsuario(u,p);
                    Toast.makeText(this, "Inicio de sesion exitoso", Toast.LENGTH_LONG).show();
                    Intent i2 = new Intent(this, RegistroUsuarios.class);
                    i2.putExtra("id", ux.getId());
                    startActivity(i2);
                    finish();
                }else{
                    Toast.makeText(this, "usuario y/o contraseña incorrectos", Toast.LENGTH_LONG).show();

                }
                break;
            case R.id.btnRegistrar:
                Intent i = new Intent(this, Registro.class);
                startActivity(i);
                break;
        }
    }
}