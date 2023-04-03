package com.example.mycollege;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    TextView openreg,forget;
    EditText emaillog,passwordlog;
    ProgressBar progressbar;
    Button butttonlog;
    String emailid,password;
    FirebaseAuth auth;

   /* @Override
    protected void onStart() {
        super.onStart();
        if(auth.getCurrentUser() != null){
            openmain();
        }
    }

    private void openmain() {
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        openreg = findViewById(R.id.sign);
        emaillog=findViewById(R.id.logemail);
        passwordlog=findViewById(R.id.logpassword);
        butttonlog=findViewById(R.id.Loginbutton);

        forget = findViewById(R.id.Forget);

        auth = FirebaseAuth.getInstance();

        openreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Openreg();
            }
        });


        butttonlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkvalid();
            }
        });

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openforget();
            }
        });
    }

    private void openforget() {

        startActivity(new Intent(this, forget.class));
        finish();
    }

    private void checkvalid() {
        emailid = emaillog.getText().toString();
        password = passwordlog.getText().toString();

        if(emailid.isEmpty()){
            emaillog.setError("Required");
            emaillog.requestFocus();
        }
        else if(password.isEmpty()){
            passwordlog.setError("Required");
            passwordlog.requestFocus();
        }
        else {
            loginuser();
        }

    }

    private void loginuser() {

        auth.signInWithEmailAndPassword(emailid,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                openmainactivity();
                                progressbar.setVisibility(View.VISIBLE);
                            }
                            else {
                                Toast.makeText(login.this, "Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(login.this, "Error"+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void openmainactivity() {
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

    private void Openreg() {
        startActivity(new Intent(this, Register.class));
        finish();
    }
}