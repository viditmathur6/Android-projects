package com.example.recyclerview;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecylerviewAdapter extends RecyclerView.Adapter<RecylerviewAdapter.viewholde> {

    private int lasposition =-1;
    Context context;
    ArrayList<Contectmodel> arrcontans = new ArrayList<>();

    RecylerviewAdapter(Context context, ArrayList<Contectmodel> arrcontans){
        this.context = context;
        this.arrcontans = arrcontans;
    }
    @NonNull
    @Override
    public viewholde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(context).inflate(R.layout.contact_card,parent,false);
       viewholde viewholde = new viewholde(v);
        return viewholde;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholde holder, int position) {
        holder.imageView.setImageResource(arrcontans.get(position).img);
        holder.textView1.setText(arrcontans.get(position).name);
        holder.textView2.setText(arrcontans.get(position).contect);
        setanimation(holder.itemView, position);


        //
        holder.raw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.addcontats);
                EditText editText1,editText2;
                Button button;

                editText1 = dialog.findViewById(R.id.Text3);
                editText2 = dialog.findViewById(R.id.Text4);
                button = dialog.findViewById(R.id.button);
                TextView text = dialog.findViewById(R.id.update);
                text.setText("Update Contacts ");
                button.setText("Update");
                editText1.setText((arrcontans.get(position)).name);
                editText2.setText(arrcontans.get(position).contect);

               button.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       String name="", number="";
                       if(!editText1.getText().toString().equals("")) {
                           name = editText1.getText().toString();
                       }
                       else {
                           Toast.makeText(context, "please enter name !", Toast.LENGTH_SHORT).show();
                       }

                       if(!editText2.getText().toString().equals("")) {
                           number = editText2.getText().toString();
                       }
                       else {
                           Toast.makeText(context, "please enter Number  !", Toast.LENGTH_SHORT).show();
                       }

                       arrcontans.set(position, new Contectmodel(R.drawable.ghg,name, number));
                       notifyItemChanged(position);
                        dialog.dismiss();
                   }
               });
                dialog.show();
            }
        });

        holder.raw.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Delete Contact")
                .setMessage("Are you sure want Delete ?")
                        .setIcon(R.drawable.ic_delete)
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                    arrcontans.remove(position);
                                    notifyItemRemoved(position);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                builder.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrcontans.size();
    }

    public class viewholde extends RecyclerView.ViewHolder{
    TextView textView1,textView2;
    ImageView imageView;
    LinearLayout raw;
        public viewholde(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.text1);
            textView2 = itemView.findViewById(R.id.text2);
            imageView = itemView.findViewById(R.id.image);
            raw = itemView.findViewById(R.id.row);
        }
    }

    private void setanimation(View viewtoanimate, int position){
        if(position>lasposition) {
            Animation slidein = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewtoanimate.startAnimation(slidein);
            lasposition = position;
        }
    }
}
