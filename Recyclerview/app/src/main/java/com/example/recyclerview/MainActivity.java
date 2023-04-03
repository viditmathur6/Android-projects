package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    ArrayList<Contectmodel> arrcontct = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recviews);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Contectmodel contectmodel = new Contectmodel(R.drawable.ghg, "a", "9828913449");

        arrcontct.add(new Contectmodel(R.drawable.ghg, "rahul","5658454845"));
        arrcontct.add(new Contectmodel(R.drawable.ghg, "rahul","5658454845"));
        arrcontct.add(new Contectmodel(R.drawable.ghg, "rahul","5658454845"));
        arrcontct.add(new Contectmodel(R.drawable.ghg, "rahul","5658454845"));
        arrcontct.add(new Contectmodel(R.drawable.ghg, "rahul","5658454845"));
        arrcontct.add(new Contectmodel(R.drawable.ghg, "rahul","5658454845"));
        arrcontct.add(new Contectmodel(R.drawable.ghg, "rahul","5658454845"));
        arrcontct.add(new Contectmodel(R.drawable.ghg, "rahul","5658454845"));
        arrcontct.add(new Contectmodel(R.drawable.ghg, "rahul","5658454845"));
        arrcontct.add(new Contectmodel(R.drawable.ghg, "rahul","5658454845"));
        arrcontct.add(new Contectmodel(R.drawable.ghg, "rahul","5658454845"));

        arrcontct.add(new Contectmodel(R.drawable.ghg, "rahul","5658454845"));

        arrcontct.add(new Contectmodel(R.drawable.ghg, "rahul","5658454845"));

        arrcontct.add(new Contectmodel(R.drawable.ghg, "rahul","5658454845"));

        arrcontct.add(new Contectmodel(R.drawable.ghg, "rahul","5658454845"));
        arrcontct.add(new Contectmodel(R.drawable.ghg, "rahul","5658454845"));

        arrcontct.add(new Contectmodel(R.drawable.ghg, "rahul","5658454845"));

        RecylerviewAdapter recylerviewAdapter = new RecylerviewAdapter(this, arrcontct);
        recyclerView.setAdapter(recylerviewAdapter);


        // Add delete
        fab  = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.addcontats);
                EditText editText1,editText2;
                Button button;

                editText1 = dialog.findViewById(R.id.Text3);
                editText2 = dialog.findViewById(R.id.Text4);
                button = dialog.findViewById(R.id.button);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                            String name="", number="";
                        if(!editText1.getText().toString().equals("")) {
                            name = editText1.getText().toString();
                        }
                        else {
                            Toast.makeText(MainActivity.this, "please enter name !", Toast.LENGTH_SHORT).show();
                        }

                        if(!editText2.getText().toString().equals("")) {
                            number = editText2.getText().toString();
                        }
                        else {
                            Toast.makeText(MainActivity.this, "please enter Number  !", Toast.LENGTH_SHORT).show();
                        }

                        arrcontct.add(new Contectmodel(R.drawable.ghg,name, number));
                        recylerviewAdapter.notifyItemInserted(arrcontct.size()-1);
                        recyclerView.scrollToPosition(arrcontct.size()-1);


                    }
                });
                dialog.show();

            }
        });




    }
}