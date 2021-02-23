package com.example.aplikacija;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RezultatCatchTheBall extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezultat_catch_the_ball);
        TextView scoreLabel=(TextView)findViewById(R.id.scoreLabel);
        TextView high=(TextView)findViewById(R.id.high);
        Button izadji=(Button)findViewById(R.id.izadji);
        izadji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(RezultatCatchTheBall.this,NovaStranica.class);
                startActivity(i);
            }
        });
        int score=getIntent().getIntExtra("REZULTAT",0);
        scoreLabel.setText(score+"");
        SharedPreferences settings=getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
        int highScore=settings.getInt("HIGH_SCORE",0);
        if(score>highScore){
            high.setText("High score : "+score);

            SharedPreferences.Editor editor=settings.edit();
            editor.putInt("HIGH_SCORE",score);
            editor.commit();
        }else{
            high.setText("High score: "+highScore);
        }

    }
    public void tryAgain(View view){
        startActivity(new Intent(getApplicationContext(),CatchTheBall.class));
    }



}
