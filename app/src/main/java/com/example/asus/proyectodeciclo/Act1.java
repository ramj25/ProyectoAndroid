package com.example.asus.proyectodeciclo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Act1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act1);

        Button btn1_1=findViewById(R.id.btn1_1);
        Button btn1_2=findViewById(R.id.btn1_2);

        btn1_1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(),Act1_1.class);
                startActivity(i);
            }
        });

        btn1_2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(),Act1_2.class);
                startActivity(i);
            }
        });

    }
}
