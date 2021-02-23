package com.example.aplikacija;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.system.Os;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity{
    DatabaseHelper db;
    EditText etEmail,etPass,etName,etConPass;
    Button btnReg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        db=new DatabaseHelper(this);
        etName=(EditText)findViewById(R.id.etName);
        etEmail=(EditText)findViewById(R.id.etEmail);
        etPass=(EditText)findViewById(R.id.etPass);
        etConPass=(EditText)findViewById(R.id.etConPass);
        btnReg=(Button)findViewById(R.id.btnRegister);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email,pass,name,conpass;
                name=etName.getText().toString();
                conpass=etConPass.getText().toString();
                email=etEmail.getText().toString();
                pass=etPass.getText().toString();
                if (name.equals("")){
                    Toast.makeText(Registration.this,"Name is required",Toast.LENGTH_SHORT).show();
                }
                else if (email.equals("")){
                    Toast.makeText(Registration.this,"E-mail is required",Toast.LENGTH_SHORT).show();
                }
                else if (pass.equals("")){
                    Toast.makeText(Registration.this,"Password is required",Toast.LENGTH_SHORT).show();

                }
                else if (conpass.equals("")) {
                    Toast.makeText(Registration.this, "Password confirmation is required", Toast.LENGTH_SHORT).show();

                }
                else if(!conpass.equals(pass)){
                    Toast.makeText(Registration.this,"Password doesn't match",Toast.LENGTH_SHORT).show();

                }
                else{
                    Boolean checkmail=db.chkmail(email);
                   if (checkmail==true){
                       Boolean insert=db.insert(email,pass);
                       if(insert==true){
                           Toast.makeText(getApplicationContext(),"Successfully registration",Toast.LENGTH_SHORT).show();
                           Intent i=new Intent(Registration.this,MainActivity.class);
                           startActivity(i);
                       }
                   } else{
                       Toast.makeText(getApplicationContext(),"E-mail already exists",Toast.LENGTH_SHORT).show();
                   }
                }
            }
        });
    }
}
