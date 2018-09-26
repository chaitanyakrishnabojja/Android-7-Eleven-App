package com.example.android.seveneleven;

import java.io.Serializable;

public class NameAndDescription implements Serializable {
    private String mName;
    private String mDescription;
    private String mCategory;
    private double mPrice;


    public NameAndDescription(String name, String description, String category, double price){
        mName = name;
        mDescription = description;
        mCategory = category;
        mPrice = price;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getCategory() {
        return mCategory;
    }

    public double getPrice() {
        return mPrice;
    }
}
