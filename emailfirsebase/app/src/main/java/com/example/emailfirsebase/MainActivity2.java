package com.example.emailfirsebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView openreg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        openreg = findViewById(R.id.openreg);

        openreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openreg();
            }
        });
    }

    private void openreg() {
        startActivity(new Intent(this,MainActivity.class));
        finish();

    }
}