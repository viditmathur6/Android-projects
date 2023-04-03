package com.example.bundlepassing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String course = intent.getStringExtra("course");
        int rollno = intent.getIntExtra("rollno", 0);

        TextView textView;
        textView = findViewById(R.id.textview);
        textView.setText("Name :"+name+"course :"+course+"Roll No :"+rollno);

    }
}