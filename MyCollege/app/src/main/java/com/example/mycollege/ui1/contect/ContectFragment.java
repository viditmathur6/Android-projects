package com.example.mycollege.ui1.contect;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mycollege.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class ContectFragment extends Fragment {

    private RecyclerView deletenoticerecylr;
    private ProgressBar progressbar;
    private noticeAdapter adapter;
    private DatabaseReference reference;
    private ArrayList<noticedata> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contect, container, false);

        deletenoticerecylr=view.findViewById(R.id.deletenoticerecyler);
        progressbar=view.findViewById(R.id.progreesbar);
        reference = FirebaseDatabase.getInstance().getReference().child("Notice");
        deletenoticerecylr.setLayoutManager(new LinearLayoutManager(getContext()));
        deletenoticerecylr.setHasFixedSize(true);

        getnotice();


        return view;
    }

    private void getnotice() {

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<>();

                for (DataSnapshot snapshot1 :snapshot.getChildren()){
                    noticedata data = snapshot1.getValue(noticedata.class);
                    list.add(data);

                }
                adapter = new noticeAdapter(getContext(),list);
                adapter.notifyDataSetChanged();
                progressbar.setVisibility(View.GONE);
                deletenoticerecylr.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressbar.setVisibility(View.GONE);
                Toast.makeText(getContext(),error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}