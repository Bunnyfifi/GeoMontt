package com.example.geomontt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class mostrar extends AppCompatActivity {
ListView lista;
daoUsuario dao;
String admin="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        lista=(ListView) findViewById(R.id.lista);
        dao = new daoUsuario(this);
        ArrayList<Usuario> l = dao.selectUsuarios();
        ArrayList<String> list=new ArrayList<String>();
        for (Usuario u:l) {
            if (u.getRol()==1){
                admin = "Usuario administrador";
            }else{
                admin = "Usuario normal";
            }
            list.add("Nombre: " + u.getNombre()+" Apellido: "+u.getApellidos()+" Tipo usuario: " + admin );
        }
        ArrayAdapter<String> a= new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,list);
        lista.setAdapter(a);
}}