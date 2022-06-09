package com.example.asus.proyectodeciclo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Act1_1 extends AppCompatActivity {

 /* public String urlPartidos="https://api.myjson.com/bins/1bsdya/";*/
 /*public String urlPartidos="https://api.myjson.com/bins/6wjri/";*/




 public String urlPartidos="https://gist.githubusercontent.com/ramj25/cf9a2a01d3b459adb0ae084a0df05ff3/raw/";

 /*https://gist.github.com/ramj25/cf9a2a01d3b459adb0ae084a0df05ff3  user:ramj25     */





    public ArrayList<Partido> miListaPartidos=new ArrayList<>();


    public static Button btns1;
    public static Button btns2;
    public static Button btns3;
    public static Button btns4;
    public static Button btns5;
    public static Button btns6;
    public static Button btns7;
    public static Button btns8;
    public static Button btnE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act1_1);



        btns1=findViewById(R.id.btns1);
        btns2=findViewById(R.id.btns2);
        btns3=findViewById(R.id.btns3);
        btns4=findViewById(R.id.btns4);
        btns5=findViewById(R.id.btns5);
        btns6=findViewById(R.id.btns6);
        btns7=findViewById(R.id.btns7);
        btns8=findViewById(R.id.btns8);
        btnE=findViewById(R.id.btnE);


        final LinearLayout vista=findViewById(R.id.vista);
        final LinearLayout view1=findViewById(R.id.view1);

        for(int i=1;i<10;i++) {
            String url = "http://res.cloudinary.com/dvekizjpw/image/upload/sprites/collages/g" + i + ".png";


            final int finalI = i;
            Glide.with(this).load(url).into(new SimpleTarget<Drawable>() {
                @Override
                public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        vista.findViewWithTag(finalI +"").setBackground(resource);
                    }
                }
            });
        }


            /*(Drawable)Glide.with(getApplicationContext()).load(url).into((Button)view1.findViewWithTag("i"));

          */






        getPartidos();



    }



/*

    public void btnClick_Normal(View v){

        Intent intent=new Intent(Act1_1.this,Act1_1_1.class);
        int id1=(Integer.parseInt((String)v.getTag()));
        ArrayList<Partido> listaEq=new ArrayList<>();

        for(int i=(((id1-1)*6)); i<=(id1*6)-1;i++ ) {

            listaEq.add(miListaPartidos.get(i));

        }
        intent.putExtra("listaEq",  listaEq);
        startActivity(intent);
    }



    public void btnClick_Especial(View v){

        Intent intent=new Intent(getApplicationContext(),Act1_1_2.class);
        ArrayList<Partido> listaEq=new ArrayList<>();

        for(int i=48; i<=63;i++ ) {

            listaEq.add(miListaPartidos.get(i));
        }
        intent.putExtra("listaEq2", listaEq);
        startActivity(intent);
    }


*/

    public void getPartidos(){

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonObjectRequest jSonObjectRequest=new JsonObjectRequest(
                Request.Method.GET,urlPartidos, null, new Response.Listener<JSONObject>(){
            public void onResponse(JSONObject response){
                try{
                    JSONArray jsonArrayPartidos=response.getJSONArray("results");
                    if(jsonArrayPartidos.length()>0) {
                        for (int i = 0; i < jsonArrayPartidos.length(); i++) {
                            JSONObject jsonPartido = jsonArrayPartidos.getJSONObject(i);

                            int id =Integer.parseInt(jsonPartido.getString("id"));
                            String detalles = jsonPartido.getString("details");
                            String equipo1 = jsonPartido.getString("team1");
                            String equipo2 = jsonPartido.getString("team2");
                            Integer goles1;
                            if(jsonPartido.getString("goals1").equals("")){goles1=null;}
                            else{goles1=Integer.parseInt(jsonPartido.getString("goals1"));}
                            Integer goles2;
                            if(jsonPartido.getString("goals2").equals("")){goles2=null;}
                            else{goles2=Integer.parseInt(jsonPartido.getString("goals2"));}

                             /*final Integer goles1 = Integer.parseInt(jsonPartido.getString("goals1"));
                            final Integer goles2 = Integer.parseInt(jsonPartido.getString("goals2")); */

                            Partido nuevoPartido = new Partido(id, detalles, equipo1, equipo2, goles1, goles2);
                            miListaPartidos.add(nuevoPartido);

                        }


                      View.OnClickListener onClickListener = new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                int id1=(Integer.parseInt((String)v.getTag()));
                                if (id1==9){

                                    Intent intent=new Intent(getApplicationContext(),Act1_1_2.class);
                                    ArrayList<Partido> listaEq=new ArrayList<>();

                                    for(int i=48; i<=63;i++ ) {

                                        listaEq.add(miListaPartidos.get(i));
                                    }
                                    intent.putExtra("listaEq2", listaEq);
                                    startActivity(intent);




                                }

                                else{
                                Intent intent=new Intent(Act1_1.this,Act1_1_1.class);

                                ArrayList<Partido> listaEq=new ArrayList<>();

                                for(int i=(((id1-1)*6)); i<=(id1*6)-1;i++ ) {

                                    listaEq.add(miListaPartidos.get(i));

                                }
                                intent.putExtra("listaEq",  listaEq);
                                intent.putExtra("grupo", ""+v.getTag());

                                startActivity(intent);}



                            }
                        };

                        Act1_1.btns1.setOnClickListener(onClickListener);
                        Act1_1.btns2.setOnClickListener(onClickListener);
                        Act1_1.btns3.setOnClickListener(onClickListener);
                        Act1_1.btns4.setOnClickListener(onClickListener);
                        Act1_1.btns5.setOnClickListener(onClickListener);
                        Act1_1.btns6.setOnClickListener(onClickListener);
                        Act1_1.btns7.setOnClickListener(onClickListener);
                        Act1_1.btns8.setOnClickListener(onClickListener);
                        Act1_1.btnE.setOnClickListener(onClickListener);



















                        }}
                catch(JSONException je){


                    je.printStackTrace();
                    Log.d("ERR",je.getMessage()) ;

                }

            } },  new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
            }
        }
        );
        requestQueue.add(jSonObjectRequest);
    }





     /* Adaptador miAdaptador=new Adaptador(getApplicationContext(),miListaEquipos);
                        lstEquipos.setAdapter(miAdaptador);

                        lstEquipos.setOnItemClickListener(new AdapterView.OnItemClickListener(){









                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                Intent intent = new Intent(getApplicationContext(),Act1_2_1.class);
                                Equipo equipo=miListaEquipos.get(position);

                                intent.putExtra("id",equipo.getId());
                                intent.putExtra("nombre",equipo.getNombre());
                                intent.putExtra("perfil",equipo.getPerfil());
                                intent.putExtra("grupo",equipo.getGrupo());
                                intent.putExtra("ranking",equipo.getRanking());
                                intent.putExtra("apariciones",equipo.getApariciones());

                                startActivity(intent);
                            }


                        public void btnClick_Normal(View v){


                            Intent intent=new Intent(getApplicationContext(),Act1_1_1.class);
                            int id1=(String)v.getTag();


                            startActivity(intent);


                        }


                        public void btnClick_Especial(View v){

                            Intent intent=new Intent(getApplicationContext(),Act1_1_2.class);
                            startActivity(intent);


                        } */


}
