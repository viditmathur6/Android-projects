package com.example.mycollege;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.mycollege.ui.contectus.ContectusFragment;
import com.example.mycollege.ui.doubts.DoubtsFragment;
import com.example.mycollege.ui.notes.NotesFragment;
import com.example.mycollege.ui.settings.settingsFragment;
import com.example.mycollege.ui.share.shareFragment;
import com.example.mycollege.ui.videos.videosFragment;
import com.example.mycollege.ui1.contect.ContectFragment;
import com.example.mycollege.ui1.earn.EarnFragment;
import com.example.mycollege.ui1.faculty.facultyFragment;
import com.example.mycollege.ui1.home.homeFragment;
import com.example.mycollege.ui1.profile.profileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {



    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;
    FirebaseAuth auth;
    DatabaseReference reference;
   // TextView usernameee,useremaileee;
   // NavigationView navigation_item;
  //  String nameuser,emailuser,uid;
    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //notification

        FirebaseMessaging.getInstance().subscribeToTopic("notifaction");


        drawerLayout = findViewById(R.id.drawer);
     //   navigationView = findViewById(R.id.navigationview);
        toolbar = findViewById(R.id.toolbar);
        bottomNavigationView = findViewById(R.id.bottomview);

       // usernameee = navigationView.getHeaderView(0).findViewById(R.id.namehader);
    //    useremaileee = navigationView.getHeaderView(0).findViewById(R.id.emailheadr);


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
     /*   if (user != null) {
            // Name, email address, and profile photo Url
            nameuser = user.getDisplayName();
            emailuser = user.getEmail();
            boolean emailVerified = user.isEmailVerified();
            uid = user.getUid();
        }else {
            openlogin();
        }
        usernameee.setText(nameuser);
        useremaileee.setText(emailuser);
*/







        // toolbar
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.Open_drawer,R.string.Close_drawer );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        // drwaernavigation

      /*  navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int a = item.getItemId();

                if(a==R.id.notes){
                    load(new NotesFragment(),1);
                }
                else if(a==R.id.videos){
                    load(new videosFragment(),1);
                }
                else if(a==R.id.doubts){
                    load(new DoubtsFragment(),1);
                }
                else if(a==R.id.setings){
                    load(new settingsFragment(),1);
                }
                else if(a==R.id.share){
                    load(new shareFragment(),1);
                }
                else {
                    load(new ContectusFragment(),1);
                }

                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });

*/

        // bottom navigation

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if(id == R.id.home){
                    load(new homeFragment(),0);
                }
                else if(id == R.id.notice){
                    load(new ContectFragment(),1);
                }
                else if(id == R.id.earn){
                    load(new EarnFragment(), 1);
                }
                else if(id == R.id.faculty){
                    load(new facultyFragment(),1);
                }
                else{
                    load(new profileFragment(),1);
                }


                return true;

            }
        });

      //  bottomNavigationView.setSelectedItemId(R.id.home);



        //user profile




        
        

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.optionmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.logout){
            auth.signOut();
            openlogin();
        }

        return true;
    }

    private void openlogin() {
        startActivity(new Intent(this,login.class));
        finish();
    }

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }


    }

    private void load(Fragment fragment, int flag) {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

       if(flag == 0)
           ft.add(R.id.cointer, fragment);
       else
           ft.replace(R.id.cointer, fragment);
           ft.commit();


    }
}