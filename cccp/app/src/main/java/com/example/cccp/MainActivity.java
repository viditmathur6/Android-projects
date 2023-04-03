package com.example.cccp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


private EditText email,password;
private TextView show;
RelativeLayout button;
private String Email,PAssword;
private SharedPreferences sharedPreferences; // after login we bar bar login ni krna pde
private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password= findViewById(R.id.password);
        button = findViewById(R.id.login);
        show=findViewById(R.id.show);

        sharedPreferences = this.getSharedPreferences("Login",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        if(sharedPreferences.getString("isLogin","false").equals("true")){
            openDash();
        }


        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(password.getInputType()==144){
                    password.setInputType(129);
                    show.setText("Hide");
                }
                else {
                    password.setInputType(144);
                    show.setText("Show");
                }
                password.setSelection(password.getText().length());//for last index

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validatedata();
            }
        });
    }

    private void validatedata() {

        Email = email.getText().toString();
        PAssword = password.getText().toString();

        if(Email.isEmpty()){
            email.setError("Requried");
            email.requestFocus();
        }
        else if(PAssword.isEmpty()){
            password.setError("Requried");
            password.requestFocus();
        }
        else if(Email.equals("user@gmail.com") && PAssword.equals("1234")){
            editor.putString("isLogin","yes");
            editor.commit();
            openDash();
        }
        else {
            Toast.makeText(this, "Email id And Password wrong", Toast.LENGTH_SHORT).show();
        }
    }

    private void openDash() {


        startActivity(new Intent(MainActivity.this,MainActivity2.class));
        finish();
    }
}