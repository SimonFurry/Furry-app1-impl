package com.example.furryapp1impl;

import java.util.ArrayList;

public class Items {
    private String description;
    private String date;

    public Items(){
        this.description = "";
        this.date = "";
    }
    public Items(String description, String date){
        this.description = description;
        this.date = date;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date = date;
    }
}
