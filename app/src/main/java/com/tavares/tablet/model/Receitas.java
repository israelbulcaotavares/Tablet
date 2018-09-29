package com.tavares.tablet.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Receitas implements Serializable{
    public String id;
    public  int mId;
    private String mName;
    private String mServings;
    private String mImage;
    private ArrayList<Ingredientes> ingredientesArrayList;
    private ArrayList<Steps> stepsArrayList;

    public Receitas() {
    }

    public Receitas(int mId, String mName, String mServings,
                    String mImage, ArrayList<Ingredientes> ingredientesArrayList) {
        this.mId = mId;
        this.mName = mName;
        this.mServings = mServings;
        this.mImage = mImage;
        this.ingredientesArrayList = ingredientesArrayList;
    }


    public Receitas(int mId, String mName, String mServings, String mImage,
      ArrayList<Ingredientes> ingredientesArrayList, ArrayList<Steps> stepsArrayList) {
        this.mId = mId;
        this.mName = mName;
        this.mServings = mServings;
        this.mImage = mImage;
        this.ingredientesArrayList = ingredientesArrayList;
        this.stepsArrayList = stepsArrayList;
    }

    public ArrayList<Steps> getStepsArrayList() {
        return stepsArrayList;
    }

    public void setStepsArrayList(ArrayList<Steps> stepsArrayList) {
        this.stepsArrayList = stepsArrayList;
    }

    public ArrayList<Ingredientes> getIngredientesArrayList() {
        return ingredientesArrayList;
    }

    public void setIngredientesArrayList(ArrayList<Ingredientes> ingredientesArrayList) {
        this.ingredientesArrayList = ingredientesArrayList;
    }

    public int getmId() {
        return mId;
    }

    public String getmName() {
        return mName;
    }

    public String getmServings() {
        return mServings;
    }

    public String getmImage() {
        return mImage;
    }

}