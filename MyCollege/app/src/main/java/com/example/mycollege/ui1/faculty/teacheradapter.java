package com.example.mycollege.ui1.faculty;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycollege.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class teacheradapter extends RecyclerView.Adapter<teacheradapter.TeacherViewAdapter> {

    private List<teacherdata> list;
    private Context context;

    public teacheradapter(List<teacherdata> list, Context context){
        this.list=list;
        this.context=context;
    }


    @NonNull
    @Override
    public teacheradapter.TeacherViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.faculty_layout, parent, false);
        return new TeacherViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull teacheradapter.TeacherViewAdapter holder, int position) {
        teacherdata item = list.get(position);
        holder.name.setText(item.getName());
        holder.post.setText(item.getPost());
        holder.email.setText(item.getEmail());

        Picasso.get().load(item.getImage()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TeacherViewAdapter extends RecyclerView.ViewHolder {
        private TextView name,post,email;
      //  private Button update;
        private ImageView imageView;

        public TeacherViewAdapter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.teachername);
            post = itemView.findViewById(R.id.teacherpost);
            email = itemView.findViewById(R.id.teacheremail);
          //  update = itemView.findViewById(R.id.teacherupdate);
            imageView = itemView.findViewById(R.id.teacherimage);

        }
    }
}
