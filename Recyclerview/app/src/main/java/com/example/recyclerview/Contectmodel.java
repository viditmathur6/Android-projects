package com.example.recyclerview;

public class Contectmodel {

    int img;
    String name, contect;


    public Contectmodel(int img, String name, String contect){
        this.img = img;
        this.name = name;
        this.contect = contect;
    }

    public  Contectmodel(String name, String number){
        this.name = name;
        this.contect = number;
    }
}
