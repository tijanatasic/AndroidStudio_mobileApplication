package com.example.aplikacija;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Pogodi extends AppCompatActivity {

    Button iv11, iv12, iv13, iv21, iv22, iv23, iv31, iv32, iv33, iv41, iv42, iv43;
    Integer[] card = {101, 102, 103, 104, 105, 106, 201, 202, 203, 204, 205, 206};
    int camel, coala, fox, lion, monkey, wolf, camel1, coala1, fox1, lion1, monkey1, wolf1;
    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pogodi);
        iv11 = (Button) findViewById(R.id.button4);
        iv12 = (Button) findViewById(R.id.button5);
        iv13 = (Button) findViewById(R.id.button6);
        iv21 = (Button) findViewById(R.id.button7);
        iv22 = (Button) findViewById(R.id.button8);
        iv23 = (Button) findViewById(R.id.button9);
        iv31 = (Button) findViewById(R.id.button10);
        iv32 = (Button) findViewById(R.id.button11);
        iv33 = (Button) findViewById(R.id.button12);
        iv41 = (Button) findViewById(R.id.button13);
        iv42 = (Button) findViewById(R.id.button14);
        iv43 = (Button) findViewById(R.id.button15);



        iv11.setTag("0");
        iv12.setTag("1");
        iv13.setTag("2");
        iv21.setTag("3");
        iv22.setTag("4");
        iv23.setTag("5");
        iv31.setTag("6");
        iv32.setTag("7");
        iv33.setTag("8");
        iv41.setTag("9");
        iv42.setTag("10");
        iv43.setTag("11");

        frontOfTheCard();

        Collections.shuffle(Arrays.asList(card));

        iv11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard=Integer.parseInt((String) v.getTag());
                doStuff(iv11,theCard);
            }
        });

        iv12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard=Integer.parseInt((String) v.getTag());
                doStuff(iv12,theCard);
            }
        });

        iv13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard=Integer.parseInt((String) v.getTag());
                doStuff(iv13,theCard);
            }
        });

        iv21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard=Integer.parseInt((String) v.getTag());
                doStuff(iv21,theCard);
            }
        });

        iv22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard=Integer.parseInt((String) v.getTag());
                doStuff(iv22,theCard);
            }
        });

        iv23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard=Integer.parseInt((String) v.getTag());
                doStuff(iv23,theCard);
            }
        });

        iv31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard=Integer.parseInt((String) v.getTag());
                doStuff(iv31,theCard);
            }
        });

        iv32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard=Integer.parseInt((String) v.getTag());
                doStuff(iv32,theCard);
            }
        });

        iv33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard=Integer.parseInt((String) v.getTag());
                doStuff(iv33,theCard);
            }
        });

        iv41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard=Integer.parseInt((String) v.getTag());
                doStuff(iv41,theCard);
            }
        });

        iv42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard=Integer.parseInt((String) v.getTag());
                doStuff(iv42,theCard);
            }
        });

        iv43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard=Integer.parseInt((String) v.getTag());
                doStuff(iv43,theCard);
            }
        });

    }

    private void doStuff(Button iv,int card1) {
        if (card[card1] == 101) {
            iv.setBackgroundResource(camel);
        } else if (card[card1] == 102) {
            iv.setBackgroundResource(coala);
        } else if (card[card1] == 103) {
            iv.setBackgroundResource(fox);
        } else if (card[card1] == 104) {
            iv.setBackgroundResource(lion);
        } else if (card[card1] == 105) {
            iv.setBackgroundResource(monkey);
        } else if (card[card1] == 106) {
            iv.setBackgroundResource(wolf);
        } else if (card[card1] == 201) {
            iv.setBackgroundResource(camel1);
        } else if (card[card1] == 202) {
            iv.setBackgroundResource(coala1);
        } else if (card[card1] == 203) {
            iv.setBackgroundResource(fox1);
        } else if (card[card1] == 204) {
            iv.setBackgroundResource(lion1);
        } else if (card[card1] == 205) {
            iv.setBackgroundResource(monkey1);
        } else if (card[card1] == 206) {
            iv.setBackgroundResource(wolf1);
        }
        if(cardNumber==1){
            firstCard=card[card1];
            if(firstCard>200){
                firstCard=firstCard-100;
            }
            cardNumber=2;
            clickedFirst=card1;

            iv.setEnabled(false);
        }else if(cardNumber==2){
            secondCard=card[card1];
            if(secondCard>200){
                secondCard=secondCard-100;
            }
            cardNumber=1;
            clickedSecond=card1;
            iv11.setEnabled(false);
            iv12.setEnabled(false);
            iv13.setEnabled(false);
            iv21.setEnabled(false);
            iv22.setEnabled(false);
            iv23.setEnabled(false);
            iv31.setEnabled(false);
            iv32.setEnabled(false);
            iv33.setEnabled(false);
            iv41.setEnabled(false);
            iv42.setEnabled(false);
            iv43.setEnabled(false);

            Handler handler=new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    calculate();
                }
            },1000);
        }
    }

    private void calculate(){
        if(firstCard==secondCard){
            if(clickedFirst==0){
                iv11.setVisibility(View.INVISIBLE);
            }else if(clickedFirst==1){
                iv12.setVisibility(View.INVISIBLE);
            }else if(clickedFirst==2){
                iv13.setVisibility(View.INVISIBLE);
            }else if(clickedFirst==3){
                iv21.setVisibility(View.INVISIBLE);
            }else if(clickedFirst==4){
                iv22.setVisibility(View.INVISIBLE);
            }else if(clickedFirst==5){
                iv23.setVisibility(View.INVISIBLE);
            }else if(clickedFirst==6){
                iv31.setVisibility(View.INVISIBLE);
            }else if(clickedFirst==7){
                iv32.setVisibility(View.INVISIBLE);
            }else if(clickedFirst==8){
                iv33.setVisibility(View.INVISIBLE);
            }else if(clickedFirst==9){
                iv41.setVisibility(View.INVISIBLE);
            }else if(clickedFirst==10){
                iv42.setVisibility(View.INVISIBLE);
            }else if(clickedFirst==11){
                iv43.setVisibility(View.INVISIBLE);
            }
            if(clickedSecond==0){
                iv11.setVisibility(View.INVISIBLE);
            }else if(clickedSecond==1){
                iv12.setVisibility(View.INVISIBLE);
            }else if(clickedSecond==2){
                iv13.setVisibility(View.INVISIBLE);
            }else if(clickedSecond==3){
                iv21.setVisibility(View.INVISIBLE);
            }else if(clickedSecond==4){
                iv22.setVisibility(View.INVISIBLE);
            }else if(clickedSecond==5){
                iv23.setVisibility(View.INVISIBLE);
            }else if(clickedSecond==6){
                iv31.setVisibility(View.INVISIBLE);
            }else if(clickedSecond==7){
                iv32.setVisibility(View.INVISIBLE);
            }else if(clickedSecond==8){
                iv33.setVisibility(View.INVISIBLE);
            }else if(clickedSecond==9){
                iv41.setVisibility(View.INVISIBLE);
            }else if(clickedSecond==10){
                iv42.setVisibility(View.INVISIBLE);
            }else if(clickedSecond==11){
                iv43.setVisibility(View.INVISIBLE);
            }

        }else{
            iv11.setBackgroundResource(R.drawable.upitnik);
            iv12.setBackgroundResource(R.drawable.upitnik);
            iv13.setBackgroundResource(R.drawable.upitnik);
            iv21.setBackgroundResource(R.drawable.upitnik);
            iv22.setBackgroundResource(R.drawable.upitnik);
            iv23.setBackgroundResource(R.drawable.upitnik);
            iv31.setBackgroundResource(R.drawable.upitnik);
            iv32.setBackgroundResource(R.drawable.upitnik);
            iv33.setBackgroundResource(R.drawable.upitnik);
            iv41.setBackgroundResource(R.drawable.upitnik);
            iv42.setBackgroundResource(R.drawable.upitnik);
            iv43.setBackgroundResource(R.drawable.upitnik);
        }

        iv11.setEnabled(true);
        iv12.setEnabled(true);
        iv13.setEnabled(true);
        iv21.setEnabled(true);
        iv22.setEnabled(true);
        iv23.setEnabled(true);
        iv31.setEnabled(true);
        iv32.setEnabled(true);
        iv33.setEnabled(true);
        iv41.setEnabled(true);
        iv42.setEnabled(true);
        iv43.setEnabled(true);

        checkEnd();
    }

    private void checkEnd(){
        if(iv11.getVisibility()==View.INVISIBLE && iv12.getVisibility()==View.INVISIBLE && iv13.getVisibility()==View.INVISIBLE &&
                iv21.getVisibility()==View.INVISIBLE && iv22.getVisibility()==View.INVISIBLE && iv23.getVisibility()==View.INVISIBLE &&
                iv31.getVisibility()==View.INVISIBLE && iv32.getVisibility()==View.INVISIBLE && iv33.getVisibility()==View.INVISIBLE &&
                iv41.getVisibility()==View.INVISIBLE && iv42.getVisibility()==View.INVISIBLE && iv43.getVisibility()==View.INVISIBLE){
            AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(Pogodi.this);
            alertDialogBuilder.setMessage("Igra je gotova");
            alertDialogBuilder.setCancelable(false);
            alertDialogBuilder.setPositiveButton("Nova igra", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent i=new Intent(getApplicationContext(),Pogodi.class);
                    startActivity(i);
                    finish();
                }
            }).setNegativeButton("Izlaz", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent i=new Intent(getApplicationContext(),NovaStranica.class);
                    startActivity(i);
                    finish();
                }
            });

            AlertDialog alertDialog=alertDialogBuilder.create();
            alertDialog.show();

        }

    }

    private void frontOfTheCard(){
        camel=R.drawable.camel;
        coala=R.drawable.coala;
        fox=R.drawable.fox;
        lion=R.drawable.lion;
        monkey=R.drawable.monkey;
        wolf=R.drawable.wolf;
        camel1=R.drawable.camel1;
        coala1=R.drawable.coala1;
        fox1=R.drawable.fox1;
        lion1=R.drawable.lion1;
        monkey1=R.drawable.monkey1;
        wolf1=R.drawable.wolf1;
    }

    
}