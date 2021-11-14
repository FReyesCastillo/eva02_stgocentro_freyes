package com.example.eva02_freyes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Redes_act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redes);


    }

    public void Facebook(View View){

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.facebook.com"));
        startActivity(i);
    }

    public void Playstore(View View){

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://play.google.com/store/apps?hl=es_419&gl=US"));
        startActivity(i);
    }

    public void Github(View View){

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://github.com/FReyesCastillo/eva02_stgocentro_freyes"));
        startActivity(i);
    }

    public void Twitter(View View){

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.twitter.com"));
        startActivity(i);
    }

}