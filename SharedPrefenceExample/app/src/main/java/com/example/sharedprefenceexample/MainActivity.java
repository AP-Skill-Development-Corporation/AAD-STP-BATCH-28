package com.example.sharedprefenceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   EditText name,email,password;
   Button reg,log;
   SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.et_name);
        email=findViewById(R.id.et_email);
        password=findViewById(R.id.et_password);
        preferences=getSharedPreferences("apssdc",MODE_PRIVATE);
    }

    public void register(View view) {
        String u_name=name.getText().toString();
        String u_password=password.getText().toString();
        SharedPreferences.Editor editor=preferences.edit();
        if(u_name.equals("")){
            Toast.makeText(this, "User name", Toast.LENGTH_SHORT).show();
        }
        else if(u_password.equals("")){
            Toast.makeText(this, "enter password", Toast.LENGTH_SHORT).show();
        }
        else{
        editor.putString("name",u_name);
        editor.putString("password",u_password);
        editor.apply();
        Toast.makeText(this, "Enter user registration successfully", Toast.LENGTH_SHORT).show();
        Intent i= new Intent(MainActivity.this,LoginActivity.class);
        startActivity(i);
        }
    }

    public void login(View view) {
        Intent i =new Intent(MainActivity.this,LoginActivity.class);
        startActivity(i);


    }

}