package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Spinner spinner;

    AutoCompleteTextView autoCompleteTextView;

    int arr[] = new int[]{1,2,3,4};

    ArrayList<String> arrnumber = new ArrayList<>();

    ArrayList<String> arrid = new ArrayList<>();

    ArrayList<String> arrauto = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // list view
        listView = findViewById(R.id.listview);

        arrnumber.add("vidit");
        arrnumber.add("bahti");
        arrnumber.add("sushil");
        arrnumber.add("sanjy");
        arrnumber.add("rahul");
        arrnumber.add("titik");
        arrnumber.add("mhaberr");
        arrnumber.add("pannku");
        arrnumber.add("vidit");
        arrnumber.add("bahti");
        arrnumber.add("sushil");
        arrnumber.add("sanjy");
        arrnumber.add("rahul");
        arrnumber.add("titik");
        arrnumber.add("mhaberr");
        arrnumber.add("pannku");
        arrnumber.add("vidit");
        arrnumber.add("bahti");
        arrnumber.add("sushil");
        arrnumber.add("sanjy");
        arrnumber.add("rahul");
        arrnumber.add("titik");
        arrnumber.add("mhaberr");
        arrnumber.add("pannku");




        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrnumber);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    Toast.makeText(MainActivity.this, "clcik on first ", Toast.LENGTH_SHORT).show();

                }
            }
        });


        //spinner

        spinner = findViewById(R.id.spinner);
        arrid.add("Adhar Card");
        arrid.add("Pan Card");
        arrid.add("Voter Id Card");
        arrid.add("Ration Card");
        arrid.add("Student Card");


        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arrid);
        spinner.setAdapter(adapter1);


        // auto complete
        autoCompleteTextView = findViewById(R.id.autocom);
        arrauto.add("java");
        arrauto.add("C++");
        arrauto.add("vidit");
        arrauto.add("faltu");
        arrauto.add("javaaaaaaaa");
        arrauto.add("java Corder vidit");
        arrauto.add("vidit hello");
        arrauto.add("java rahul");
        arrauto.add("jav kan");
        arrauto.add("ja lu");

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrauto);
        autoCompleteTextView.setAdapter(adapter2);
        autoCompleteTextView.setThreshold(2);






    }
}