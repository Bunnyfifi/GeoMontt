package com.example.geomontt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
//EditText user, pass;
//Button btnEntrar, btnRegistrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        user=(EditText) findViewById(R.id.User);
    }
    public void menu(View view){
        Intent i = new Intent(this, Menu.class);
        startActivity(i);
    }
    public void registro(View view){
        Intent i = new Intent(this, Registro.class);
        startActivity(i);
    }
}