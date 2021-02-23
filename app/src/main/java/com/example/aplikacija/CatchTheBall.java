package com.example.aplikacija;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class CatchTheBall extends AppCompatActivity {

    private TextView score,start;
    private ImageView box,orange,black,pink;

    private int frameHeight;
    private int boxSize;

    int boxY;
    private int orangeX;
    private int orangeY;
    private int pinkX;
    private int pinkY;
    private int blackX;
    private int blackY;
    private int rez=0;


    private int screenW;
    private int screenH;

    private Handler handler=new Handler();
    private Timer timer=new Timer();

    private boolean action_fig=false;
    private boolean star_fig=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catch_the_ball);

        score=(TextView) findViewById(R.id.score);
        start=(TextView)findViewById(R.id.start);
        box=(ImageView) findViewById(R.id.box);
        orange=(ImageView)findViewById(R.id.orange);
        black=(ImageView)findViewById(R.id.black);
        pink=(ImageView)findViewById(R.id.pink);

        WindowManager wm=getWindowManager();
        Display disp=wm.getDefaultDisplay();
        Point size= new Point();
        disp.getSize(size);
        screenW=size.x;
        screenH=size.y;

        orange.setX(-80.0f);
        orange.setY(-80.0f);
        black.setX(-80.0f);
        black.setY(-80.0f);
        pink.setX(-80.0f);
        pink.setY(-80.0f);
        score.setText("Rezultat : 0");
        boxY=500;


    }


    public void changePos(){
        hitCheck();
        orangeX-=12;
        if(orangeX<0){
            orangeX=screenW+20;
            orangeY=(int)Math.floor(Math.random()*(frameHeight-orange.getHeight()));
        }
        orange.setX(orangeX);
        orange.setY(orangeY);

        blackX-=16;
        if(blackX<0){
            blackX=screenW+10;
            blackY=(int)Math.floor(Math.random()*(frameHeight-black.getHeight()));
        }
        black.setX(blackX);
        black.setY(blackY);

        pinkX-=20;
        if(pinkX<0){
            pinkX=screenW+5000;
            pinkY=(int)Math.floor(Math.random()*(frameHeight-pink.getHeight()));
        }
        pink.setX(pinkX);
        pink.setY(pinkY);

        if(action_fig==true){
            boxY-=20;
        }else{
            boxY+=20;
        }

        if(boxY<0){
            boxY=0;
        }

        if (boxY > frameHeight - boxSize) {
            boxY=frameHeight-boxSize;
        }

        box.setY(boxY);
        score.setText("Rezultat : "+rez);
    }

    public void hitCheck(){
        int orangeCenterX=orangeX+orange.getWidth()/2;
        int orangeCenterY=orangeY+orange.getHeight()/2;

        if(0<=orangeCenterX && orangeCenterX<=boxSize && boxY<=orangeCenterY && orangeCenterY<=boxY+boxSize){
            rez +=10;
            orangeX=-10;
        }

        int pinkCentX=pinkX+pink.getWidth()/2;
        int pinkCentY=pinkY+pink.getHeight()/2;

        if(0<=pinkCentX && pinkCentX<=boxSize && boxY<=pinkCentY && pinkCentY<=boxY+boxSize){
            rez +=30;
            pinkX=-10;
        }

        int blackCenX=blackX+black.getWidth()/2;
        int blackCentY=blackY+black.getHeight()/2;
        if(0<=blackCenX && blackCenX<=boxSize && boxY<=blackCentY && blackCentY<=boxY+boxSize){
            timer.cancel();
            timer=null;
            Intent i=new Intent(getApplicationContext(),RezultatCatchTheBall.class);
            i.putExtra("REZULTAT",rez);
            startActivity(i);
        }

    }

    public boolean onTouchEvent(MotionEvent me){
        if(star_fig==false){
            star_fig=true;
            FrameLayout frame=(FrameLayout) findViewById(R.id.frame);
            frameHeight=frame.getHeight();

            boxY =(int) box.getY();
            boxSize=box.getHeight();

            start.setVisibility(View.GONE);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            changePos();
                        }
                    });
                }
            },0,20);
        }else{
            if(me.getAction()==MotionEvent.ACTION_DOWN){
                action_fig=true;
            }else if(me.getAction()==MotionEvent.ACTION_UP){
                action_fig=false;
            }
        }

        return true;
    }
}
