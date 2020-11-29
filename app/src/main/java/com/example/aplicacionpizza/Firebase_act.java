package com.example.aplicacionpizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import Models.Clientes;

public class Firebase_act extends AppCompatActivity {

    private EditText nombre, destino, promocion;
    private Button button;

    FirebaseDatabase firebase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_act);

        nombre = (EditText)findViewById(R.id.nombre_ed);
        destino = (EditText)findViewById(R.id.destino_ed);
        promocion = (EditText)findViewById(R.id.promocion_ed);

        inicializarBase();

    }

    public void GuardarCliente(View v){
        if(!nombre.getText().equals(""))
        {
            Clientes p = new Clientes();
            p.setId(UUID.randomUUID().toString());
            p.setNombre(nombre.getText().toString());
            p.setDestino(destino.getText().toString());
            p.setPromocion(promocion.getText().toString());

            databaseReference.child("Clientes").child(p.getId()).setValue(p);

            Toast.makeText(getBaseContext(), "Se han guardado los datos", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getBaseContext(), "Debe rellenar los campos", Toast.LENGTH_LONG).show();
        }
    }

    public void ListadoClientes(View v){
        Intent i = new Intent(getBaseContext(), ListadoClientes_act.class);
        startActivity(i);
    }

    public void inicializarBase(){
        FirebaseApp.initializeApp(this);
        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference();
    }
}