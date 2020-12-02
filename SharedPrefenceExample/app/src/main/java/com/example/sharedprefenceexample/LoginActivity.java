package com.example.sharedprefenceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
     EditText et_name,et_password;
     SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_name=findViewById(R.id.name);
        et_password=findViewById(R.id.password);
        preferences=getSharedPreferences("apssdc",MODE_PRIVATE);


    }

    public void ok(View view) {
        String user_given_name=et_name.getText().toString();
        String user_given_password=et_password.getText().toString();
        String reg_user=preferences.getString("name","");
        String reg_pass=preferences.getString("password","");
    if(user_given_name.equals(reg_user)&& user_given_password.equals(reg_pass))
    {

        Toast.makeText(this, "Login sucessfully", Toast.LENGTH_SHORT).show();

    }
    else{
        Toast.makeText(this, "Wrong data enter", Toast.LENGTH_SHORT).show();
    }
    }
}