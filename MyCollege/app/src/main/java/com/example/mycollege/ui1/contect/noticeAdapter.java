package com.example.mycollege.ui1.contect;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mycollege.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class noticeAdapter  extends RecyclerView.Adapter<noticeAdapter.NoticeViewAdapter> {
    private Context context;
    private ArrayList<noticedata> list;

    public noticeAdapter(Context context, ArrayList<noticedata> list){
        this.context=context;
        this.list=list;

    }
    @NonNull
    @Override
    public noticeAdapter.NoticeViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_feed, parent, false);

        return new NoticeViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull noticeAdapter.NoticeViewAdapter holder, int position) {
        noticedata currentitem = list.get(position);
        holder.deletenoticetittle.setText(currentitem.getTitle());
        holder.date.setText(currentitem.getDate());
        holder.time.setText(currentitem.getTime());
        try {
            if(currentitem.getImage() != null)
                Glide.with(context).load(currentitem.getImage()).into(holder.imagedelete);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NoticeViewAdapter extends RecyclerView.ViewHolder {
   //     private Button deletenotice;

        private TextView deletenoticetittle,date,time;
        private ImageView imagedelete;

        public NoticeViewAdapter(@NonNull View itemView) {
            super(itemView);
          // deletenotice = itemView.findViewById(R.id.deletenotice);
            deletenoticetittle =itemView.findViewById(R.id.noticetittle);
            imagedelete = itemView.findViewById(R.id.iamgedelete);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
        }
    }
}