package com.example.emailfirsebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    EditText name, email, pas;
    private Button Rbutton;
    private String names , emailreg , pass;
    private FirebaseAuth auth;
    private DatabaseReference referese,dbref;
    private TextView openlog;


    @Override
    protected void onStart() {
        super.onStart();
        if(auth.getCurrentUser() != null){
            openmain();
        }
    }

    private void openmain() {
        startActivity(new Intent(this,MainActivity3.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // register Activity

        name = findViewById(R.id.registername);
        email = findViewById(R.id.registeremail);
        pas = findViewById(R.id.registerpassword);
        Rbutton = findViewById(R.id.registerbutton);
        openlog = findViewById(R.id.openlog);

        openlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlog();
            }
        });


        referese = FirebaseDatabase.getInstance().getReference();
        auth = FirebaseAuth.getInstance();


        Rbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validdata();
            }
        });
    }

    private void openlog() {

        startActivity(new Intent(this,MainActivity2.class));
        finish();
    }

    private void validdata() {

        names = name.getText().toString();
        emailreg = email.getText().toString();
        pass = pas.getText().toString();

        if(names.isEmpty()){
            name.setError("Required");
            name.requestFocus();
        }
        else if(emailreg.isEmpty()){
            email.setError("Required");
            email.requestFocus();
        }
        else if(pass.isEmpty()){
            pas.setError("Required");
            pas.requestFocus();
        }
        else {
            Createuser();
        }
    }

    private void Createuser(){
        auth.createUserWithEmailAndPassword(emailreg,pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            uploaddatauser();

                        }
                        else {
                            Toast.makeText(MainActivity.this, "Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Error"+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void uploaddatauser() {
       dbref = referese.child("user");
       String key = dbref.push().getKey();

        HashMap<String, String> user = new HashMap<>();
        user.put("key",key);
        user.put("Name",names);
        user.put("Email",emailreg);

        dbref.child(key).setValue(user)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "User Created", Toast.LENGTH_SHORT).show();
                            openmain();
                        }
                        else {
                            Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}