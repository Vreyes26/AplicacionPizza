package com.example.aplicacionpizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText user, pass;
    private TextView tv;
    private String usuario, contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText)findViewById(R.id.etUsuario);
        pass = (EditText)findViewById(R.id.etContraseña);
        tv = (TextView)findViewById(R.id.tvError);
    }

    public void botonEnviar(View v){
        usuario = user.getText().toString().toUpperCase();
        contraseña = pass.getText().toString().toUpperCase();
        if(usuario.equals("ANDROID") && contraseña.equals("123")){
            Intent i = new Intent(getBaseContext(), Menu_act.class);
            startActivity(i);
        }
        else{
            tv.setText("Usuario o contraseña, incorrectos");
        }
    }
}