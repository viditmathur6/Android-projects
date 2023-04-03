package com.example.mycollege;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reels.databinding.ReelsABinding;

import java.util.ArrayList;

public class ReelAdapter extends RecyclerView.Adapter<ReelAdapter.ViewHolder> {

    Context context;
    ArrayList<model> models = new ArrayList<>();
    boolean ispalaying = false;

    public ReelAdapter(Context context, ArrayList<model> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.reels,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        model model = models.get(position); //optional
        holder.binding.videoView.setVideoPath(models.get(position).getVideoUrl());
        holder.binding.name.setText(models.get(position).getName());
        holder.binding.profile.setImageResource(models.get(position).getProfile());
        holder.binding.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
                ispalaying=true;
            }
        });
        holder.binding.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
                ispalaying=true;
            }
        });
        holder.binding.videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ispalaying)
                {
                    holder.binding.videoView.pause();
                    ispalaying=false;
                }
                else {
                    holder.binding.videoView.resume();
                    ispalaying=true;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ReelsABinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ReelsABinding.bind(itemView);
        }
    }
}
