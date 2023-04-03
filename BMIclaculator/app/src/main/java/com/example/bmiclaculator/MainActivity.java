package com.example.bmiclaculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText weight, height;
    private TextView textView;
    private AppCompatButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        textView = findViewById(R.id.text);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(weight.getText().toString());
                int he = Integer.parseInt(height.getText().toString());

                int cont = he/100;
                int bmi = wt/(cont*cont);

                if(bmi>25){
                    textView.setText("You need food ");

                }
                else if(bmi<25){
                    textView.setText("Your are over weight");
                }
                else{
                    textView.setText("you are good ");
                }

            }
        });

    }
}