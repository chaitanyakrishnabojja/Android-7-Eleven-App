package com.example.android.seveneleven;

import java.util.ArrayList;

public class LoadedOrderData {
    private static ArrayList<Order> orderArrayList;

    public static ArrayList<Order> getOrderArrayList() {
        return orderArrayList;
    }

    public static void setOrderArrayList(ArrayList<Order> orderArrayList) {
        LoadedOrderData.orderArrayList = orderArrayList;
    }
}
