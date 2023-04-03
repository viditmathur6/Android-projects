package com.example.expandablelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    MyExpendableListviewAdapter adapter;
    List<String> category;
    Map<String, List<String>> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView = findViewById(R.id.expendlistview);

        getalldata();

        adapter = new MyExpendableListviewAdapter(this, category, names);
        expandableListView.setAdapter(adapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                Toast.makeText(MainActivity.this,category.get(i)+ ":"+names.get(category.get(i)).get(i1), Toast.LENGTH_SHORT).show();
                if(names.get(category.get(i)).get(i1)=="Lili"){
                    startActivity(new Intent(MainActivity.this,MainActivity2.class));
                }
                return false;

            }
        });
    }

    private void getalldata() {
        category = new ArrayList<String>();
        names = new HashMap<String, List<String>>();
        // add parent
        category.add("Fruits");
        category.add("Flowers");
        category.add("Animals");

        // add child
        List<String> Fruits = new ArrayList<String>();
        Fruits.add("Mango");
        Fruits.add("Apple");
        Fruits.add("Banana");
        Fruits.add("Papya");

        List<String> Flowers = new ArrayList<String>();
        Flowers.add("Rose");
        Flowers.add("Lili");
        Flowers.add("Pink Rose");
        Flowers.add("Lotus");

        List<String> Animals = new ArrayList<String >();
        Animals.add("Lion");
        Animals.add("Cat");
        Animals.add("Dog");
        Animals.add("Mouse");

        names.put(category.get(0),Fruits);
        names.put(category.get(1),Flowers);
        names.put(category.get(2),Animals);

    }
}