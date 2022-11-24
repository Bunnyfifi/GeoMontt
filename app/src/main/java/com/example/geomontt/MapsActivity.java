package com.example.geomontt;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.geomontt.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    EditText titulo;
    Spinner marcadores;
    Button guardar;
    LatLng punto;

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        titulo = (EditText) findViewById(R.id.titulo);
        marcadores=(Spinner) findViewById(R.id.marcadores);
        guardar = (Button) findViewById(R.id.guardar);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-41.4723143, -72.9395789);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Plaza de armas"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,15));
        mMap.setOnMapLongClickListener((latLng) -> {
            mMap.clear();
            punto = latLng;
            mMap.addMarker(new MarkerOptions().position(punto).title("Nuevo Marcador"));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(punto,16));
            titulo.setEnabled(true);
            guardar.setEnabled(true);
        });
        mostrar();
    }
    public void guardar (View view){
        Marcador marcador = new Marcador(titulo.getText().toString().trim(),punto.latitude, punto.longitude);
        marcador.ingresar(this);
        titulo.setText("");
        titulo.setEnabled(false);
        guardar.setEnabled(false);
        mostrar();
    }
    public void mostrar(){
        marcadores.setAdapter(new Marcador().obtenerMarcadores(this));
    }
    public void mostrarMarcador (View view){
        mMap.clear();
        Marcador m = (Marcador) marcadores.getSelectedItem();
        punto = new LatLng(m.getLatitud(),m.getLongitud());
        mMap.addMarker(new MarkerOptions().position(punto).title(m.getTitulo()));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(punto,17));
    }
}