package com.example.eva02_freyes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

import Clases.Insumos;

public class Home_act extends AppCompatActivity {

    private VideoView video;
    private Insumos in = new Insumos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        video = findViewById(R.id.videoView);  // llamo al video
        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video; //Obtener ruta del video
        Uri uri = Uri.parse(ruta); // parseo de ruta
        video.setVideoURI(uri);  // le paso mi ruta al videView
        video.start(); // iniciar video al iniciar sesión

    }
    public void Insumos(View View){
        Intent i = new Intent(this, Insumos_act.class);
        Bundle bun = new Bundle(); // necesario para enviar arreglos
        bun.putStringArray("insumos", in.getInsumos());
        i.putExtras(bun);
        startActivity(i);
    }

    public void Redes(View View){
        Intent i = new Intent(this, Redes_act.class);
        startActivity(i);
    }

    public void Info(View View){
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }

    public void Sqlite(View View){
        Intent i = new Intent(this, Sqlite_act.class);
        startActivity(i);
    }
}