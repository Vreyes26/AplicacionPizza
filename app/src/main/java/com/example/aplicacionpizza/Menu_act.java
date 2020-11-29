package com.example.aplicacionpizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class Menu_act extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);

        videoView = (VideoView)findViewById(R.id.videoView);

        String ruta ="android.resource://"+getPackageName()+"/"+R.raw.video;
        Uri uri = Uri.parse(ruta);
        videoView.setVideoURI(uri);

        MediaController media = new MediaController(this);
        videoView.setMediaController(media);
        videoView.start();
    }

    public void Gestion(View v){
        Intent i = new Intent(getBaseContext(), Firebase_act.class);
        startActivity(i);
    }

    public void Promocion(View v){
        Intent i = new Intent(getBaseContext(), Promociones_act.class);
        startActivity(i);
    }
}