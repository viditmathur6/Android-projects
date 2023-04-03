package com.example.customlistviewwithcardview;

import java.security.PublicKey;
import java.util.PrimitiveIterator;

public class listdata {
    private int image;
    private String title;
    private String description;

    public listdata(int image, String title, String description){
        this.image = image;
        this.title = title;
        this.description = description;

    }
    public int getImage(){
        return image;

    }
    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }

}
