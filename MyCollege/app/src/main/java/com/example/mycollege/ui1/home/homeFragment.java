package com.example.mycollege.ui1.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mycollege.R;
import com.example.mycollege.slideradapter;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;


public class homeFragment extends Fragment {

    private SliderView sliderView;
    private int[] image;
    private String[] text;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

   /*     sliderView = view.findViewById(R.id.slider);


        image =new int[]{R.drawable.mlsu, R.drawable.mput, R.drawable.ru, R.drawable.jnvuss};
        text = new String[]{"Mohanlal shukhadia University","Maharana Paratap University","Rajasthan University","Jay Narayana Vyas University"};

        slideradapter adapter = new slideradapter(image,text);
        sliderView.setSliderAdapter(adapter);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.DROP);
        sliderView.startAutoCycle();*/
        return view;
    }
}
