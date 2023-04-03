package com.example.implicetactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
    Button call,message,email,share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        call = findViewById(R.id.call);
        message = findViewById(R.id.message);
        email = findViewById(R.id.email);
        share = findViewById(R.id.share);



        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent inten = new Intent(Intent.ACTION_DIAL);
                inten.setData(Uri.parse("tel: +919413823449"));
                startActivity(inten);
            }
        });



        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:"+Uri.encode("+919413823449")));
                intent.putExtra("sms_body","please slove this issue");
                startActivity(intent);

            }
        });


        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setType("message/rfc822");
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"abc@gmail.com","shg@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT,"abc");
                email.putExtra(Intent.EXTRA_TEXT,"hello");
                startActivity(Intent.createChooser(email,"Emailvisa"));

            }
        });


        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_TEXT,"Download imaging app");
                startActivity(Intent.createChooser(share,"Share via"));

            }
        });
    }
}