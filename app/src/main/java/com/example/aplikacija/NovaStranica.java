package com.example.aplikacija;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NovaStranica extends AppCompatActivity {
    Button btnPrva,btnDruga,btnTreca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_stranica);
        btnPrva=(Button)findViewById(R.id.button);
        btnDruga=(Button)findViewById(R.id.button2);
        btnTreca=(Button)findViewById(R.id.button3);

        btnPrva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(NovaStranica.this,IksOks.class);
                startActivity(i);
            }
        });

        btnDruga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(NovaStranica.this,Pogodi.class);
                startActivity(i);
            }
        });

        btnTreca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(NovaStranica.this,CatchTheBall.class);
                startActivity(i);
            }
        });
    }
}
