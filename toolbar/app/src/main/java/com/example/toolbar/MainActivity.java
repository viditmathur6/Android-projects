package com.example.toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);

        // setp 1
        setSupportActionBar(toolbar);

        //setp2
        if (getSupportActionBar()!=null){
         //   getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            setTitle("My Toolbar");

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         new MenuInflater(this).inflate(R.menu.tool_item,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemid = item.getItemId();

        if (itemid == R.id.gallry){
            Toast.makeText(this, "Gallery", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Search ", Toast.LENGTH_SHORT).show();

        }

        return super.onOptionsItemSelected(item);
    }
}