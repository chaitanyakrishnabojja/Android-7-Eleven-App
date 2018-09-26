package com.example.android.seveneleven;

import java.util.ArrayList;

public class ModelProducts {

    private ArrayList<NameAndDescription> mNamesAndDescriptions;

    private static final ModelProducts ourInstance = new ModelProducts();

    public static ModelProducts getInstance() {
        return ourInstance;
    }

    private ModelProducts() {
        mNamesAndDescriptions = new ArrayList<NameAndDescription>();

        // Some hardcoded dummy data
// Create a new entry
        NameAndDescription tempEntry = new NameAndDescription("Diet-Coke", "591ml bottle", "Drinks", 1.2);
// Add it to the ArrayList
        mNamesAndDescriptions.add(tempEntry);
// Create a new entry
        tempEntry = new NameAndDescription("pepsi", "2 Liters bottle", "Drinks", 1.5);
// Add it to the ArrayList
        mNamesAndDescriptions.add(tempEntry);
// Create a new entry
       tempEntry = new NameAndDescription("Gatorade", "1 Litre bottle", "Energy Drink", 1);
// Add it to the ArrayList
        mNamesAndDescriptions.add(tempEntry);
        tempEntry = new NameAndDescription("French Venila", "Small Cup", "Coffee", 2);
// Add it to the ArrayList
        mNamesAndDescriptions.add(tempEntry);
// Create a new entry
        tempEntry = new NameAndDescription("Hot Chocolate", "Large Cup", "Coffee", 2.5);
// Add it to the ArrayList
        mNamesAndDescriptions.add(tempEntry);
    }

    public ArrayList <NameAndDescription> getProducts(){
        return mNamesAndDescriptions;
    }
}
