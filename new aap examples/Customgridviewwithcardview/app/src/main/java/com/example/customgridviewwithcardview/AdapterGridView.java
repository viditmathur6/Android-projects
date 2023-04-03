package com.example.customgridviewwithcardview;

import android.content.Context;
import android.media.Image;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class AdapterGridView extends BaseAdapter {

    Context context;
    ArrayList<Gridviewdata> gridviewdata;

    public AdapterGridView(Context context, ArrayList<Gridviewdata> gridviewdata){
        this.context = context;
        this.gridviewdata = gridviewdata;

    }


    @Override
    public int getCount() {
        return gridviewdata.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
     view = LayoutInflater.from(context).inflate(R.layout.custom_grid,viewGroup,false);
        ImageView imageView = view.findViewById(R.id.icon);
        TextView textView = view.findViewById(R.id.title);
        imageView.setImageResource(gridviewdata.get(i).getImage());
        textView.setText(gridviewdata.get(i).getTitle());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Name :"+gridviewdata.get(i).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
