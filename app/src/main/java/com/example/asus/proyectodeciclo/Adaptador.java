package com.example.asus.proyectodeciclo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adaptador extends ArrayAdapter<Equipo>{

    Context context;

    private List<Equipo> listaEquipos;

    public Adaptador(Context context, List<Equipo> equipos){
        super(context, R.layout.item, equipos);
        listaEquipos=equipos;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater= LayoutInflater.from(getContext());

        View view=convertView;

        if(view==null){
            view=inflater.inflate(R.layout.item, null);
        }
        TextView txtItem=view.findViewById(R.id.txtItem);

        ImageView imgItem=view.findViewById(R.id.imgItem);
        String url="http://res.cloudinary.com/dvekizjpw/image/upload/sprites/icons/"+listaEquipos.get(position).getId()+".png";
        Glide.with(getContext()).load(url).into(imgItem);
        txtItem.setText(listaEquipos.get(position).getNombre());
/*

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(),Act1_2_1.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra();
                getContext().startActivity(intent);

            }
        });

*/



        return view;



    }


}
