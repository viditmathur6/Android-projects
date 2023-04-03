package com.example.mycollege;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.smarteist.autoimageslider.SliderViewAdapter;

public class slideradapter extends SliderViewAdapter<slideradapter.SliderViewHolder> {

    private int[] image;
    private String[] text;

    public slideradapter(int[] image, String[] text) {
        this.image = image;
        this.text = text;
    }


    @Override
    public SliderViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item,null);


        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderViewHolder viewHolder, int position) {
        viewHolder.imageView.setImageResource(image[position]);
        viewHolder.textView.setText(text[position]);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getCount() {
        return image.length;
    }

    public class SliderViewHolder extends SliderViewAdapter.ViewHolder {

        private ImageView imageView;
        private TextView textView;
        public SliderViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageslider);
            textView = itemView.findViewById(R.id.textslider);
        }
    }
}
