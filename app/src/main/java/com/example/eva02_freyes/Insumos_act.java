package com.example.eva02_freyes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import Clases.Insumos;

public class Insumos_act extends AppCompatActivity {

    private Spinner insumos;
    private TextView result;
    private RatingBar calificar;
    private Insumos in = new Insumos(); // Instancia de la clase

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos);
        insumos = findViewById(R.id.spInsumos);
        result = findViewById(R.id.txtRes);
        calificar = findViewById(R.id.ratingBar);
        Bundle bun = getIntent().getExtras(); //Recibo extras
        String[] listado = bun.getStringArray("insumos");
        ArrayAdapter adaptInsumos = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listado);
        insumos.setAdapter(adaptInsumos);
    }

    public void Calcular (View View){
        String opcion = insumos.getSelectedItem().toString(); // obtengo la selección del spinner en una variable.
        int resultado = 0;
        int precio = 0;
        for(int i = 0; i< opcion.length(); i++){
            if(opcion.equals(in.getInsumos()[i])){ // pregunto por la seleccion del spinner (index)
                precio = in.getPrecios()[i]; // obtengo resultado del precio según índice
                resultado = in.anadirAdicional(in.getPrecios()[i], 450); // obtengo regla adicional
                calificar.setRating(i+1); // pinta las estrellas del rating bar
                break;
            }
        }
        result.setText("La opción seleccionada es " + opcion +"\ncon un costo correspondiente a $" + precio + "\ny su precio total es $" + resultado);
    }
}