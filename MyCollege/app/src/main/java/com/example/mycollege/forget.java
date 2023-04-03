package com.example.mycollege;

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
import com.google.firebase.auth.FirebaseAuth;


public class forget extends AppCompatActivity {

    private TextView loginback;
    private Button forgetbutton;
    private String emailidforget;
    private EditText Emailfp;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        loginback=findViewById(R.id.openloginpage);
        forgetbutton=findViewById(R.id.Forgetbutton);
        Emailfp=findViewById(R.id.forgetemail);
        auth = FirebaseAuth.getInstance();

        loginback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openloginpage();
            }
        });

        forgetbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Checkvalidation();
            }
        });
    }

    private void Checkvalidation() {
        emailidforget = Emailfp.getText().toString();

        if(emailidforget.isEmpty()){
            Emailfp.setError("Required");
            Emailfp.requestFocus();
        }
        else{
            forgetpassword();
        }
    }

    private void forgetpassword() {

        auth.sendPasswordResetEmail(emailidforget)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(forget.this, "Check your Mail", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(forget.this,login.class));
                            finish();
                        }
                        else {
                            Toast.makeText(forget.this, "Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(forget.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
    }

    private void openloginpage() {
        startActivity(new Intent(this,login.class));
        finish();
    }

}