package com.vivianafemenia.simulacroejer01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    /*
    Ejercicio 01
Desarrollar una aplicación para ayudar a dejar de fumar, la aplicación consistirá en tener un paquete
de tabaco virtual con 20 cigarrillos, cada vez que el usuario cambie un cigarro real por uno virtual
(Existirá un botón para simular la acción), la aplicación descontará un cigarro del paquete virtual,
cuando se termine un paquete, se incrementará en 5€ el contador de dinero ahorrado y se reiniciará
el paquete de tabaco con sus 20 cigarrillos originales.
La aplicación debe mantener en todo momento el estado tanto de los cigarros que quedan en el paquete
                                 actual, como del dinero ahorrado hasta el momento.
Desarrollar la aplicación en una única actividad con el diseño que el alumno quiera.

     */
    private TextView lblCigarrilos;
    private Button btnFumar;
    private EditText txtAhorro;

    private int contador;
    private int dinero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contador =20;
        dinero = 0;
        inicializaVistas();


        btnFumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Estas Fumando un Cigarrillo", Toast.LENGTH_SHORT).show();
                contador--;
                if(contador< 1){
                    dinero += 5;
                    contador = 20;
                }
                lblCigarrilos.setText(getString(R.string.cigarrilo)+contador);
                txtAhorro.setText(getString(R.string.dinero)+dinero);
            }
        });
    }

    


    private void inicializaVistas() {
        lblCigarrilos=findViewById(R.id.lblCigarrillosMain);
        btnFumar = findViewById(R.id.btnFumarMain);
        txtAhorro= findViewById(R.id.txtAhorro);

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Cigarrillos",contador);
        outState.putInt("€",dinero);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        contador=savedInstanceState.getInt("Cigarrillos");
        dinero = savedInstanceState.getInt("€");
        lblCigarrilos.setText(getText(R.string.cigarrilo)+String.valueOf(contador));
        txtAhorro.setText(getText(R.string.dinero)+String.valueOf(dinero));
    }
}