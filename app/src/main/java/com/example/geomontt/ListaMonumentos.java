package com.example.geomontt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListaMonumentos extends AppCompatActivity {
    private TextView txt1;
    private ListView lv1;

    private String monumentos[]={"Monumento a la Colonización Alemana","Chamiza"};
    private String ubicacion[]={"-41.471785°, -72.939644°", "-41.4667, -72.85"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_monumentos);
        txt1 = (TextView) findViewById(R.id.txtMonumentos);
        lv1 = (ListView) findViewById(R.id.listMonumentos);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_monumentos,monumentos);
        lv1.setAdapter(adapter);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                txt1.setText("La direccion de " + lv1.getItemAtPosition(i) + " es " + ubicacion[i]);
            }
        });
    }
}