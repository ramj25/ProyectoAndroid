package com.example.asus.proyectodeciclo;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Act1_2 extends AppCompatActivity {

    /*NO OLVIDAR:*/
    private String urlEquipos="https://api.myjson.com/bins/h9zcy/";
    private List<Equipo> miListaEquipos=new ArrayList<>();
    private ListView lstEquipos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act1_2);


        lstEquipos=(ListView)findViewById(R.id.lstEquipos);
        getEquipos();

    }

    public void getEquipos(){

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonObjectRequest jSonObjectRequest=new JsonObjectRequest(
            Request.Method.GET,urlEquipos, null, new Response.Listener<JSONObject>(){
                public void onResponse(JSONObject response){
                    try{
                        JSONArray jsonArrayEquipos=response.getJSONArray("results");
                        if(jsonArrayEquipos.length()>0){
                            for(int i=0;i<jsonArrayEquipos.length();i++){
                                JSONObject jsonEquipo=jsonArrayEquipos.getJSONObject(i);

                                final String id=jsonEquipo.getString("id");
                                final String nombre=jsonEquipo.getString("name");
                                final String perfil=jsonEquipo.getString("profile");
                                final String grupo=jsonEquipo.getString("group");
                                final String ranking=jsonEquipo.getString("ranking");
                                final String apariciones=jsonEquipo.getString("appereances");

                                final Equipo nuevoEquipo=new Equipo(id,nombre,perfil,grupo,ranking,apariciones);
                                miListaEquipos.add(nuevoEquipo);
                                }

                                Adaptador miAdaptador=new Adaptador(getApplicationContext(),miListaEquipos);
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

                            });
                        }
                }
                catch(JSONException je){ }


        } },  new Response.ErrorListener() {

            public void onErrorResponse(VolleyError error) {

            }
        }
        );

            requestQueue.add(jSonObjectRequest);
    }
}
