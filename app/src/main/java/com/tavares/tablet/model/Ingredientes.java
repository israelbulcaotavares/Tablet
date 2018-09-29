package com.tavares.tablet.model;

import java.io.Serializable;

public class Ingredientes implements Serializable {
    public int mId;
    public String quantity;
    public String measure;
    public String ingredient;
    public String name;

    public Ingredientes() {
    }

    public Ingredientes(int mId, String quantity, String measure, String ingredient) {
        this.mId = mId;
        this.quantity = quantity;
        this.measure = measure;
        this.ingredient = ingredient;
    }

    public Ingredientes(String quantity, String ingredient, String measure) {
        this.quantity = quantity;
        this.ingredient = ingredient;
        this.measure = measure;
    }


    public Ingredientes(String quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
}
