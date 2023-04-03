package com.example.firebaseproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    EditText name, email, password;
    Button button;
    FirebaseAuth auth;
    DatabaseReference reference,dbref;
    String username;
    String useremail;
    String userpassword ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        button = findViewById(R.id.button);
        password = findViewById(R.id.password);

        auth=FirebaseAuth.getInstance();

        reference = FirebaseDatabase.getInstance().getReference();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkvalid();
            }
        });




    }

    private void checkvalid() {

         username = name.getText().toString();
         useremail = email.getText().toString();
         userpassword = password.getText().toString();

        if(username.isEmpty()){
            name.setError("required");
            name.requestFocus();

        }
        else if(useremail.isEmpty()){
            email.setError("Required");
            email.requestFocus();
        }
        else if(userpassword.isEmpty()){
            password.setError("Required");
            password.requestFocus();
        }
        else{
            createuser();
        }
    }

    private void createuser() {

        auth.createUserWithEmailAndPassword(useremail,userpassword)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            uploaduserdata();
                            openmain();
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void openmain() {
        startActivity(new Intent(this,mainpage.class));
        finish();
    }

    private void uploaduserdata() {
        dbref = reference.child("user");
        String key = dbref.push().getKey();
        HashMap<String, String> user = new HashMap<>();
        user.put("key",key);
        user.put("Name",username);
        user.put("email",useremail);

        dbref.child(key).setValue(user)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "user created", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }
}
