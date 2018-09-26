package com.example.android.seveneleven;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Order{
    private String mCustomerName;
    private String mProductName;
    private int mQuantity;
    private boolean mVisa;
    private boolean mDebit;
    private boolean mCash;
    private double mTotalPrice;

    private static final String JSON_CUSTOMERNAME = "Customer Name";
    private static final String JSON_PRODUCTNAME = "product name";
    private static final String JSON_QUANTITY = "quantity" ;
    private static final String JSON_VISA = "visa";
    private static final String JSON_DEBIT = "debit";
    private static final String JSON_CASH = "cash";
    private static final String JSON_TOTALPRICE = "totalPrice";

    public Order(JSONObject jo) throws JSONException {
        mCustomerName = jo.getString(JSON_CUSTOMERNAME);
        mProductName = jo.getString(JSON_PRODUCTNAME);
        mQuantity = jo.getInt(JSON_QUANTITY);
        mVisa = jo.getBoolean(JSON_VISA);
        mDebit = jo.getBoolean(JSON_DEBIT);
        mCash = jo.getBoolean(JSON_CASH);
        mTotalPrice = jo.getDouble(JSON_TOTALPRICE);
    }

    public Order (){

    }

    public JSONObject convertToJSON() throws JSONException{
        JSONObject jo = new JSONObject();
        jo.put(JSON_CUSTOMERNAME, mCustomerName);
        jo.put(JSON_PRODUCTNAME, mProductName);
        jo.put(JSON_QUANTITY, mQuantity);
        jo.put(JSON_VISA, mVisa);
        jo.put(JSON_DEBIT, mDebit);
        jo.put(JSON_CASH, mCash);
        jo.put(JSON_TOTALPRICE, mTotalPrice);
        return jo;
    }

    public String getmCustomerName() {
        return mCustomerName;
    }

    public void setmCustomerName(String mCustomerName) {
        this.mCustomerName = mCustomerName;
    }

    public String getmProductName() {
        return mProductName;
    }

    public void setmProductName(String mProductName) {
        this.mProductName = mProductName;
    }

    public int getmQuantity() {
        return mQuantity;
    }

    public void setmQuantity(int mQuantity) {
        this.mQuantity = mQuantity;
    }

    public boolean ismVisa() {
        return mVisa;
    }

    public void setmVisa(boolean mVisa) {
        this.mVisa = mVisa;
    }

    public boolean ismDebit() {
        return mDebit;
    }

    public void setmDebit(boolean mDebit) {
        this.mDebit = mDebit;
    }

    public boolean ismCash() {
        return mCash;
    }

    public void setmCash(boolean mCash) {
        this.mCash = mCash;
    }

    public double getTotalPrice() {
        return mTotalPrice;
    }

    public void setTotalPrice(double mTotalPrice) {
        this.mTotalPrice = mTotalPrice;
    }
}
