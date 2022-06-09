package com.example.asus.proyectodeciclo;

import android.app.Activity;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.asus.proyectodeciclo.R.layout.activity_act1_1_2;

public class Act1_1_2 extends AppCompatActivity {

    /*private ListView lstFinal;*/





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_act1_1_2);





       /* Bundle bdl = getIntent().getExtras();
        ArrayList<Partido> misPartidos = bdl.getParcelable("listaEq2");*/
        ArrayList<Partido> misPartidos = (ArrayList<Partido>) getIntent().getSerializableExtra("listaEq2");

        Toast.makeText(this, "Gira tu Móvil!",
                Toast.LENGTH_LONG).show();

        ArrayList<String>junto=new ArrayList<>();

        for(Partido p:misPartidos){

             String x;
             if(p.getGoles1()==null){x=p.getId()+". "+p.getEquipo1()+" - "+p.getEquipo2()+"\n"+p.getDetalles();}
             else{x=p.getId()+". "+p.getEquipo1()+" "+p.getGoles1()+" - "+p.getGoles2()+" "+p.getEquipo2()+"\n"+p.getDetalles();}

             junto.add(x);

        }

        ArrayList<String>listaFinal=new ArrayList<>();
        ArrayList<String>listaFinal2=new ArrayList<>();


        for(int i=0;i<8;i++){
            listaFinal.add(junto.get(i));
        }

        for(int i=8;i<16;i++){
            listaFinal2.add(junto.get(i));
        }



        ListView lstFinal=findViewById(R.id.lstFinal);
        ListView lstFinal2=findViewById(R.id.lstFinal2);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this, R.layout.item2,
                R.id.itemList,
                listaFinal );

        if(this.getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT) {

            lstFinal.setAdapter(arrayAdapter);

            ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(
                    this, R.layout.item2,
                    R.id.itemList,
                    listaFinal2);

            lstFinal2.setAdapter(arrayAdapter2);


        }

    }






}
