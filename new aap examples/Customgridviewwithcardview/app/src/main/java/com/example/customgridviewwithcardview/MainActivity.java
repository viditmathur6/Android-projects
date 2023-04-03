package com.example.customgridviewwithcardview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Gridviewdata> arrayList;
    GridView gridView;
    AdapterGridView adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridlist);

        addgriddata();

        adapter = new AdapterGridView(this,arrayList);
        gridView.setAdapter(adapter);



    }

    private void addgriddata() {
        arrayList = new ArrayList<>();
        arrayList.add(new Gridviewdata(R.drawable.ghg,"Phone"));
        arrayList.add(new Gridviewdata(R.drawable.ghg,"Call"));
        arrayList.add(new Gridviewdata(R.drawable.ghg,"Add Contact"));
        arrayList.add(new Gridviewdata(R.drawable.ghg,"Message"));
        arrayList.add(new Gridviewdata(R.drawable.ghg,"Clone"));

        arrayList.add(new Gridviewdata(R.drawable.ghg,"Phone"));
        arrayList.add(new Gridviewdata(R.drawable.ghg,"Call"));
        arrayList.add(new Gridviewdata(R.drawable.ghg,"Add Contact"));
        arrayList.add(new Gridviewdata(R.drawable.ghg,"Message"));
        arrayList.add(new Gridviewdata(R.drawable.ghg,"Clone"));

        arrayList.add(new Gridviewdata(R.drawable.ghg,"Wathsaap"));

        arrayList.add(new Gridviewdata(R.drawable.ghg,"Amazon"));
        arrayList.add(new Gridviewdata(R.drawable.ghg,"Call"));
        arrayList.add(new Gridviewdata(R.drawable.ghg,"Add Contact"));
        arrayList.add(new Gridviewdata(R.drawable.ghg,"Message"));
        arrayList.add(new Gridviewdata(R.drawable.ghg,"Clone"));

        arrayList.add(new Gridviewdata(R.drawable.ghg,"Phone"));
        arrayList.add(new Gridviewdata(R.drawable.ghg,"Call"));
        arrayList.add(new Gridviewdata(R.drawable.ghg,"Add Contact"));
        arrayList.add(new Gridviewdata(R.drawable.ghg,"Message"));
        arrayList.add(new Gridviewdata(R.drawable.ghg,"Clone"));

        arrayList.add(new Gridviewdata(R.drawable.ghg,"Wathsaap"));

        arrayList.add(new Gridviewdata(R.drawable.ghg,"Amazon"));
        arrayList.add(new Gridviewdata(R.drawable.ghg,"Call"));
        arrayList.add(new Gridviewdata(R.drawable.ghg,"Add Contact"));
        arrayList.add(new Gridviewdata(R.drawable.ghg,"Message"));
        arrayList.add(new Gridviewdata(R.drawable.ghg,"Clone"));

        arrayList.add(new Gridviewdata(R.drawable.ghg,"Phone"));
        arrayList.add(new Gridviewdata(R.drawable.ghg,"Call"));
        arrayList.add(new Gridviewdata(R.drawable.ghg,"Add Contact"));
        arrayList.add(new Gridviewdata(R.drawable.ghg,"Message"));
        arrayList.add(new Gridviewdata(R.drawable.ghg,"Clone"));

        arrayList.add(new Gridviewdata(R.drawable.ghg,"Wathsaap"));

        arrayList.add(new Gridviewdata(R.drawable.ghg,"Amazon"));

    }
}