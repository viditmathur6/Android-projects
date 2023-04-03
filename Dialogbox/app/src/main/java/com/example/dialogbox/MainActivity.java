package com.example.dialogbox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Term & Condition ");
        alertDialog.setIcon(R.drawable.read);
        alertDialog.setMessage("Have you Read all the term & condition ");
        alertDialog.setPositiveButton("ok I read & Write ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Thanks", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog.show();



        // two button alert box


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


  /*      AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("want to Delete");
        builder.setIcon(R.drawable.read);
        builder.setMessage("IF you sure want to delete ");

        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Ok Item Deleted", Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "ok item not deleted", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();

   */

        // 3 button

     /*   AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Want to Delete ?");
        builder.setIcon(R.drawable.read);
        builder.setMessage("Are you sure Delete this item permanlently ?");

        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Item deleted ", Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_SHORT).show();
            }
        }).setNeutralButton("cancil", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Cancil", Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();




    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Exit ?");
        builder.setIcon(R.drawable.read);
        builder.setMessage("Are you sure Exit ?");

        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_SHORT).show();

            }
        }).setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.super.onBackPressed();

            }
        });
        builder.show();*/

    }
}