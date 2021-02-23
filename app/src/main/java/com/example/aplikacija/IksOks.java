package com.example.aplikacija;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class IksOks extends AppCompatActivity implements View.OnClickListener {

    private Button[][] buttons=new Button[3][3];

    private boolean player1=true;
    private int roundCount;
    private int player1points=0;
    private int player2points=0;
    private TextView textViewPlayer1;
    private TextView textViewPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iks_oks);
        textViewPlayer1=findViewById(R.id.igrac1);
        textViewPlayer2=findViewById(R.id.igrac2);

        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                String buttonID="button"+i+j;
                int resID=getResources().getIdentifier(buttonID,"id",getPackageName());
                buttons[i][j]=findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }

        Button buttonReset=findViewById(R.id.resetuj);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });
    }

    @Override
    public void onClick(View v) {

        if(!((Button) v).getText().toString().equals("")){
            return;
        }
        if(player1){
            ((Button) v).setText("X");
        }
        else{
            ((Button) v).setText("O");
        }
        roundCount++;
        if (check()){
            if(player1){
                player1Wins();
            } else{
                player2Wins();
            }
        } else if(roundCount==9){
            draw();
        } else{
            player1=!player1;
        }
    }

    private boolean check(){
        String[][] field=new String[3][3];
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                field[i][j]=buttons[i][j].getText().toString();
            }
        }
        for(int i=0;i<3;i++){
            if(field[i][0].equals(field[i][1]) && field[i][0].equals(field[i][2]) && !field[i][0].equals("")){
                return true;
            }
        }
        for(int i=0;i<3;i++){
            if(field[0][i].equals(field[1][i]) && field[0][i].equals(field[2][i]) && !field[0][i].equals("")){
                return true;
            }
        }

        if(field[0][0].equals(field[1][1]) && field[0][0].equals(field[2][2]) && !field[0][0].equals("")){
            return true;
        }
        if(field[0][2].equals(field[1][1]) && field[0][2].equals(field[2][0]) && !field[0][2].equals("")){
            return true;
        }
        return false;
    }

    private void player1Wins(){
        player1points++;
        Toast.makeText(this,"Igrač 1 je pobedio",Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                updatePointsText();
                resetBoard();
            }
        },800);

    }

    private void player2Wins(){
        player2points++;
        Toast.makeText(this,"Igrač 2 je pobedio",Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                updatePointsText();
                resetBoard();
            }
        },800);
    }
    private void draw(){
        Toast.makeText(this,"Nerešeno!",Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                resetBoard();
            }
        },800);

    }

    private void updatePointsText(){
        textViewPlayer1.setText("Igrač 1: "+player1points);
        textViewPlayer2.setText("Igrač 2: "+player2points);
    }

    private void resetBoard(){
        for(int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                buttons[i][j].setText("");
            }
        }
        roundCount=0;
        player1=true;
    }

    private void resetGame(){
        player1points=0;
        player2points=0;
        updatePointsText();
        resetBoard();
    }
}
