package com.example.customlistviewwithcardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdapterListView extends BaseAdapter {
    Context context;
    ArrayList<listdata> listdata;

    public AdapterListView(Context context, ArrayList<listdata> listdata){
        this.context = context;
        this.listdata = listdata;
    }

    @Override
    public int getCount() {
        return listdata.size();
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
       view = LayoutInflater.from(context).inflate(R.layout.custom_list,viewGroup,false);
        ImageView imageView = view.findViewById(R.id.icon);
        TextView textView = view.findViewById(R.id.tittle);
        TextView description = view.findViewById(R.id.description);
        imageView.setImageResource(listdata.get(i).getImage());
        textView.setText(listdata.get(i).getTitle());
        description.setText(listdata.get(i).getDescription());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Name :"+listdata.get(i).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
