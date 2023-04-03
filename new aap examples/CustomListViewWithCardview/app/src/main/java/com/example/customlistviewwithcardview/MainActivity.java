package com.example.customlistviewwithcardview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList arrayList;
    ListView listView;
    AdapterListView adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        listitemshow();

        adapter = new AdapterListView(this,arrayList);
        listView.setAdapter(adapter);
    }

    private void listitemshow() {
        arrayList = new ArrayList();
        arrayList.add(new listdata(R.drawable.ghg,"Mobile","Mobile phone is a eletronic device . Every people need mobile phones without smart phone humans are not servive"));
        arrayList.add(new listdata(R.drawable.ghg,"Mobile","Mobile phone is a eletronic device . Every people need mobile phones without smart phone humans are not servive"));
        arrayList.add(new listdata(R.drawable.ghg,"Mobile","Mobile phone is a eletronic device . Every people need mobile phones without smart phone humans are not servive"));
        arrayList.add(new listdata(R.drawable.ghg,"Mobile","Mobile phone is a eletronic device . Every people need mobile phones without smart phone humans are not servive"));
        arrayList.add(new listdata(R.drawable.ghg,"Mobile","Mobile phone is a eletronic device . Every people need mobile phones without smart phone humans are not servive"));
        arrayList.add(new listdata(R.drawable.ghg,"Mobile","Mobile phone is a eletronic device . Every people need mobile phones without smart phone humans are not servive"));
        arrayList.add(new listdata(R.drawable.ghg,"Mobile","Mobile phone is a eletronic device . Every people need mobile phones without smart phone humans are not servive"));
        arrayList.add(new listdata(R.drawable.ghg,"Mobile","Mobile phone is a eletronic device . Every people need mobile phones without smart phone humans are not servive"));


    }
}