package com.example.eva02_freyes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.os.AsyncTask;
import android.widget.Toast;

import Clases.ReglasNegocio;

public class MainActivity extends AppCompatActivity {

    private EditText user, pass;
    private ProgressBar pb;
    private Button btn;
    private ReglasNegocio pro = new ReglasNegocio();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.txtUsuario);
        pass = findViewById(R.id.txtPassword);
        pb = findViewById(R.id.progressBar);
        btn = findViewById(R.id.btn_InSesion);

        pb.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Aquí corre la tarea

                new Task().execute();
            }
        });

    }

    //tarea asincrona

    class Task extends AsyncTask<String,Void,String>{

        @Override // configuracion inicial de la tarea
        protected void onPreExecute() {
            super.onPreExecute();
            pb.setVisibility(View.VISIBLE);
        }

        @Override // encagado de procesar en segundo plano la tarea pesada
        protected String doInBackground(String... strings) {

            try {
                for(int i = 0; i<= 10; i++){
                    Thread.sleep(500);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override // finaliza la tarea asincrona
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            pb.setVisibility(View.INVISIBLE);

            String varUser = user.getText().toString().trim(); // captura de valor de usuario
            String varPass = pass.getText().toString().trim(); // captura de valor de pass


            if (varUser.equals("") || varPass.equals("")) {  // evalúa si uno o ambos campos están vacios
                Toast.makeText(getBaseContext(), "Debe ingresar usuario y contraseña para ingresar", Toast.LENGTH_SHORT).show();
            }
            else {
                Boolean resLogin = pro.ValidaLogin(varUser,varPass); //variable que almacena respuesta del método que valida el login

                if(resLogin){ // con login correcto envía a activity solicitado
                    Intent ical = new Intent(getBaseContext(), Home_act.class);
                    startActivity(ical);
                }
                else{
                    Toast.makeText(getBaseContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
            }
        }
    }

