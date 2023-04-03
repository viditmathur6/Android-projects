package com.example.cccp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {


    private SharedPreferences sharedPreferences; // after login we bar bar login ni krna pde
    private SharedPreferences.Editor editor;

    private Button buttons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        buttons=findViewById(R.id.logout);

        sharedPreferences = this.getSharedPreferences("Login",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        if(sharedPreferences.getString("isLogin","false").equals("false")){


            openlogin();
        }


        buttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("isLogin","false");
                editor.commit();
                openlogin();

            }
        });
    }

    private void openlogin() {
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

}