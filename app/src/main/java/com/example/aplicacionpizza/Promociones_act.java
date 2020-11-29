package com.example.aplicacionpizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.NumberFormat;

import Models.Promos;

public class Promociones_act extends AppCompatActivity {

    private Spinner spin;
    private EditText promocionEd, valorEd;
    private TextView tv, tvsaldo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promociones_act);

        spin = (Spinner)findViewById(R.id.spinner);
        promocionEd = (EditText)findViewById(R.id.edPromo);
        valorEd = (EditText) findViewById(R.id.edEnvio);
        tv = (TextView)findViewById(R.id.tv);
        tvsaldo = (TextView)findViewById(R.id.tvSaldo);

        String[] lista ={"Ramiro", "Rosa", "Robert"};

        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
        spin.setAdapter(adapt);

    }

    private void Clientes(int itemSelect){
        Promos promos = new Promos();
        int i = Integer.parseInt(valorEd.getText().toString());
        String promo = promocionEd.getText().toString().toUpperCase();
        if(itemSelect == 0){
            tv.setText("Estimado(a) "+promos.getCliente(itemSelect)
                    +" el final según promoción y envío es:");
            tvsaldo.setText(promos.getCalculo(i, promo));
        }else if(itemSelect == 1){
            tv.setText("Estimado(a) "+promos.getCliente(itemSelect)
                    +" el final según promoción y envío es:");
            tvsaldo.setText(promos.getCalculo(i, promo));
        }else if(itemSelect == 2){
            tv.setText("Estimado(a) "+promos.getCliente(itemSelect)
                    +" el final según promoción y envío es:");
            tvsaldo.setText(promos.getCalculo(i, promo));
        }else{
            tv.setText("Sin seleccion");
            tvsaldo.setText("");
        }
    }

    public void botonCalculo(View v){
        try {
            if (!valorEd.equals("") && !promocionEd.equals("")) {
                Clientes(spin.getSelectedItemPosition());
            } else {
                tv.setText("Ingrese los datos");
                tv.setText("$");
            }
        }catch (Exception e){
            tv.setText("Ingrese los datos");
            tv.setText("");
        }
    }

}