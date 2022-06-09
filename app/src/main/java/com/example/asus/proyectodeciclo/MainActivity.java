package com.example.asus.proyectodeciclo;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;

public class MainActivity extends AppCompatActivity {

    private String fecha = "2018-07-15 10:00:00";
    private String formato = "yyyy-MM-dd HH:mm:ss";
    private LinearLayout linear_layout_1, linear_layout_2;
    private Handler handler = new Handler();
    private Runnable runnable;

    private TextView Dias, Horas, Minutos,Segundos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        countDownStart();


        Button btn1=findViewById(R.id.btn1);
        Button btn2=findViewById(R.id.btn2);
        Button btn3=findViewById(R.id.btn3);
        Button btn4=findViewById(R.id.btn4);


        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(),Act1.class);
                startActivity(i);
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://es.wikipedia.org/wiki/Copa_Mundial_de_F%C3%BAtbol_de_2018"));
                startActivity(viewIntent);
            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("http://es.fifa.com/worldcup/"));
                startActivity(viewIntent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent share = new Intent(android.content.Intent.ACTION_SEND);
                share.setType("text/plain");
                String shareBody = "Enterate de todo sobre el mundial con esta aplicación para Android!";
                share.putExtra(android.content.Intent.EXTRA_SUBJECT, "Todo sobre Rusia 2018");
                share.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(share, "Compartir"));
            }
        });



    }


    private void initUI() {
        linear_layout_1 = findViewById(R.id.linear_layout_1);
        linear_layout_2 = findViewById(R.id.linear_layout_2);
        Dias = findViewById(R.id.Dias);
        Horas = findViewById(R.id.Horas);
        Minutos = findViewById(R.id.Minutos);
        Segundos = findViewById(R.id.Segundos);
    }


    private void countDownStart() {
        runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    handler.postDelayed(this, 1000);
                    SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
                    Date event_date = dateFormat.parse(fecha);
                    Date current_date = new Date();
                    if (!current_date.after(event_date)) {
                        long diff = event_date.getTime() - current_date.getTime();
                        long Days = diff / (24 * 60 * 60 * 1000);
                        long Hours = diff / (60 * 60 * 1000) % 24;
                        long Minutes = diff / (60 * 1000) % 60;
                        long Seconds = diff / 1000 % 60;
                        //
                        Dias.setText(String.format("%02d", Days));
                        Horas.setText(String.format("%02d", Hours));
                        Minutos.setText(String.format("%02d", Minutes));
                        Segundos.setText(String.format("%02d", Seconds));
                    } else {
                        linear_layout_1.setVisibility(View.VISIBLE);
                        linear_layout_2.setVisibility(View.GONE);
                        handler.removeCallbacks(runnable);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable, 0);
    }

    protected void onStop() {
        super.onStop();
        handler.removeCallbacks(runnable);
    }














}
