package com.example.firebaseproject;

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
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.TimeUnit;

public class mainpage extends AppCompatActivity {

    TextView name, email;
    DatabaseReference reference;
    String nameuser, emailuser,uid;
    EditText number, otp;
    Button sendotp, verify;
    FirebaseAuth auth;
    String phonenumber,verifcationid,enterotpforverify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
        name = findViewById(R.id.namefirebase);
        email = findViewById(R.id.emailfirebase);
        sendotp = findViewById(R.id.sendotp);
        verify = findViewById(R.id.verify);
        number = findViewById(R.id.phone);
        otp = findViewById(R.id.otp);
        auth = FirebaseAuth.getInstance();






        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
             nameuser = user.getDisplayName();
             emailuser = user.getEmail();
            boolean emailVerified = user.isEmailVerified();
             uid = user.getUid();
        }

        name.setText(nameuser);
        email.setText(emailuser);
        
        
        sendotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifynumber();
            }
        });
        
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                veifyotp();
            }
        });



    }

    private void verifynumber() {
        phonenumber = number.getText().toString();

        if(phonenumber.isEmpty()){
            number.setError("Requried");
            number.requestFocus();
        }
        else {
            sendingotp(phonenumber);
        }
    }

    private void veifyotp() {
        enterotpforverify = otp.getText().toString();

        if(enterotpforverify.isEmpty()) {
            otp.setError("Required");
            otp.requestFocus();
        }
        else {
            verifycode(enterotpforverify);
        }


    }

    private void sendingotp(String phonenumber) {
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(auth)
                        .setPhoneNumber("+91"+phonenumber)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }
private PhoneAuthProvider.OnVerificationStateChangedCallbacks
    mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential credential) {
           final String code  = credential.getSmsCode();
           if(code!=null){
                    verifycode(code);
           }
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {

            Toast.makeText(mainpage.this, "Verification faild", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCodeSent(@NonNull String s,
                @NonNull PhoneAuthProvider.ForceResendingToken token) {
            super.onCodeSent(s, token);
            verifcationid = s;
        }
    };

    private void verifycode(String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verifcationid,code);
        signinby(credential);
    }

    private void signinby(PhoneAuthCredential credential) {

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(mainpage.this, "login sussesful ", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(mainpage.this,afterlogin.class));
                            finish();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(mainpage.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
