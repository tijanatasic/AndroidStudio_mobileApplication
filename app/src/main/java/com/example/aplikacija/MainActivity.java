package com.example.aplikacija;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    DatabaseHelper db;
    EditText etEmail,etPass;
    Button btnLogin;
    TextView tvReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new DatabaseHelper(this);
        etEmail=(EditText)findViewById(R.id.etEmail);
        etPass=(EditText)findViewById(R.id.etPass);
        btnLogin=(Button)findViewById(R.id.btnLogin);
        tvReg=(TextView)findViewById(R.id.tvReg);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email,pass;
                email=etEmail.getText().toString();
                pass=etPass.getText().toString();
                Boolean chkemailpassword=db.chkemailpassword(email,pass);
                int dobro=1;
                if (email.equals("")){
                    Toast.makeText(MainActivity.this,"E-mail Required",Toast.LENGTH_SHORT).show();
                    dobro=0;
                }
                else if (pass.equals("")){
                    Toast.makeText(MainActivity.this,"Password Required",Toast.LENGTH_SHORT).show();
                    dobro=0;
                }
                else if(dobro==1) {
                    if (chkemailpassword == true) {
                        Toast.makeText(getApplicationContext(),"Successfully Login",Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this, NovaStranica.class);
                        startActivity(i);

                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Wrong E-mail or password",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        tvReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Registration.class);
                startActivity(i);
                finish();
            }
        });
    }
}
