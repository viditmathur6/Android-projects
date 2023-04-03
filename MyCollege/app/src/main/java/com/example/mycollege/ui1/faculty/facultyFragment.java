package com.example.mycollege.ui1.faculty;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.mycollege.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class facultyFragment extends Fragment {

    private RecyclerView Bcadepartment,mcadepartment, mscdepartment;
    private LinearLayout bcanodata, mcanodata, mscnodata;
    private List<teacherdata> list1, list2, list3;
    private DatabaseReference reference,dbref;
    private teacheradapter teacheradapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);

        Bcadepartment=view.findViewById(R.id.bcadepartment);
        mcadepartment=view.findViewById(R.id.mcadepartment);
        mscdepartment=view.findViewById(R.id.mscdepartment);
        bcanodata=view.findViewById(R.id.bcanodata);
        mcanodata=view.findViewById(R.id.mcanodata);
        mscnodata=view.findViewById(R.id.mscnodata);
        reference = FirebaseDatabase.getInstance().getReference().child("teacher");
        Bcadepartment();
        mcadepartment();
        mscdepartment();
        return view;


    }

    private void mscdepartment() {
        dbref = reference.child("Msc computer science");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3 = new ArrayList<>();

                if (!snapshot.exists()){
                    mscnodata.setVisibility(View.VISIBLE);
                    mscdepartment.setVisibility(View.GONE);

                }
                else {
                    mscnodata.setVisibility(View.GONE);
                    mscdepartment.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                        teacherdata data = snapshot1.getValue(teacherdata.class);
                        list3.add(data);

                    }
                }
                mscdepartment.setHasFixedSize(true);
                mscdepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                teacheradapter = new teacheradapter(list3, getContext());
                mscdepartment.setAdapter(teacheradapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void mcadepartment() {
        dbref = reference.child("Mca");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2 = new ArrayList<>();

                if (!snapshot.exists()){
                    mcanodata.setVisibility(View.VISIBLE);
                    mcadepartment.setVisibility(View.GONE);
                }
                else {
                    mcanodata.setVisibility(View.GONE);
                    mcadepartment.setVisibility(View.VISIBLE);


                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                        teacherdata data = snapshot1.getValue(teacherdata.class);
                        list2.add(data);

                    }
                }
                mcadepartment.setHasFixedSize(true);
                mcadepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                teacheradapter = new teacheradapter(list2, getContext());
                mcadepartment.setAdapter(teacheradapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void Bcadepartment() {

        dbref = reference.child("Bca");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1 = new ArrayList<>();

                if (!snapshot.exists()){
                    bcanodata.setVisibility(View.VISIBLE);
                    Bcadepartment.setVisibility(View.GONE);
                }
                else {
                    bcanodata.setVisibility(View.GONE);
                    Bcadepartment.setVisibility(View.VISIBLE);


                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                        teacherdata data = snapshot1.getValue(teacherdata.class);
                        list1.add(data);

                    }
                }
                Bcadepartment.setHasFixedSize(true);
                Bcadepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                teacheradapter = new teacheradapter(list1, getContext());
                Bcadepartment.setAdapter(teacheradapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}