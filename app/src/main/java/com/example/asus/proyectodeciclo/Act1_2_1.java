package com.example.asus.proyectodeciclo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import static java.lang.System.load;

public class Act1_2_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act1_2_1);
        Bundle bundle = getIntent().getExtras();
        String id=bundle.getString("id");
        String nombre=bundle.getString("nombre");
        String perfil=bundle.getString("perfil");
        String grupo=bundle.getString("grupo");
        String ranking=bundle.getString("ranking");
        String apariciones=bundle.getString("apariciones");

        ImageView imgEquipo=findViewById(R.id.imgEquipo);
        String url="http://res.cloudinary.com/dvekizjpw/image/upload/sprites/headers/"+id+".jpg";

        Glide.with(getApplicationContext()).load(url).into(imgEquipo);

        TextView txtE1=findViewById(R.id.txtE1);
        TextView txtE2=findViewById(R.id.txtE2);
        TextView txtE3=findViewById(R.id.txtE3);
        TextView txtE4=findViewById(R.id.txtE4);
        TextView txtE5=findViewById(R.id.txtE5);

        txtE1.setText(nombre);
        txtE2.setText(grupo);
        txtE3.setText(perfil);
        txtE4.setText("Ranking FIFA: "+ranking);
        txtE5.setText("Participaciones en los Mundiales: "+apariciones);

    }
}
