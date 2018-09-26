package com.example.android.seveneleven;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class PreviousOrdersActivity extends AppCompatActivity {

    public static ArrayList<Order> ordersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_orders);


            Log.e("displayList ", " " + ordersList.get(0).getmCustomerName());


        TextView textViewName1 = (TextView)findViewById(R.id.textViewName1);
        TextView textViewProduct1 = (TextView)findViewById(R.id.textViewProduct1);
        TextView textViewQuantity1 = (TextView)findViewById(R.id.textViewQuantity1);
        TextView textViewPayment1 = (TextView)findViewById(R.id.textViewPayment1);
        TextView textViewTotalPrice1 = (TextView)findViewById(R.id.textViewTotalPrice1);

        TextView textViewName2 = (TextView)findViewById(R.id.textViewName2);
        TextView textViewProduct2 = (TextView)findViewById(R.id.textViewProduct2);
        TextView textViewQuantity2 = (TextView)findViewById(R.id.textViewQuantity2);
        TextView textViewPayment2 = (TextView)findViewById(R.id.textViewPayment2);
        TextView textViewTotalPrice2 = (TextView)findViewById(R.id.textViewTotalPrice2);

        TextView textViewName3 = (TextView)findViewById(R.id.textViewName3);
        TextView textViewProduct3 = (TextView)findViewById(R.id.textViewProduct3);
        TextView textViewQuantity3 = (TextView)findViewById(R.id.textViewQuantity3);
        TextView textViewPayment3 = (TextView)findViewById(R.id.textViewPayment3);
        TextView textViewTotalPrice3 = (TextView)findViewById(R.id.textViewTotalPrice3);


        int arrayLength = ordersList.size();
        String paymentMode;
        if (arrayLength >= 1){
            Order order1 = ordersList.get(arrayLength - 1);
            textViewName1.setText("Customer Name: " + order1.getmCustomerName());
            textViewProduct1.setText("Product Name: " + order1.getmProductName());
            textViewQuantity1.setText("Quantity: " + order1.getmQuantity());
            textViewTotalPrice1.setText("Total Price: " + order1.getTotalPrice());
            if (order1.ismVisa()){
                paymentMode = "Visa";
            }else if (order1.ismDebit()){
                paymentMode = "Debit";
            }else {
                paymentMode = "Cash";
            }
            textViewPayment1.setText("Payment Type: " + paymentMode);
        }else {
            textViewName1.setText("");
            textViewProduct1.setText("");
            textViewQuantity1.setText("");
            textViewPayment1.setText("");
            textViewTotalPrice1.setText("");
        }

        if (arrayLength >= 2){
            Order order2 = ordersList.get(arrayLength - 2);
            textViewName2.setText("Customer Name: " + order2.getmCustomerName());
            textViewProduct2.setText("Product Name: " + order2.getmProductName());
            textViewQuantity2.setText("Quantity: " + order2.getmQuantity());
            textViewTotalPrice2.setText("Total Price: " + order2.getTotalPrice());
            if (order2.ismVisa()){
                paymentMode = "Visa";
            }else if (order2.ismDebit()){
                paymentMode = "Debit";
            }else {
                paymentMode = "Cash";
            }
            textViewPayment2.setText("Payment Type: " + paymentMode);
        }else {
            textViewName2.setText("");
            textViewProduct2.setText("");
            textViewQuantity2.setText("");
            textViewPayment2.setText("");
            textViewTotalPrice2.setText("");
        }

        if (arrayLength >= 3){
            Order order3 = ordersList.get(arrayLength - 3);
            textViewName3.setText("Customer Name: " + order3.getmCustomerName());
            textViewProduct3.setText("Product Name: " + order3.getmProductName());
            textViewQuantity3.setText("Quantity: " + order3.getmQuantity());
            textViewTotalPrice3.setText("Total Price: " + order3.getTotalPrice());
            if (order3.ismVisa()){
                paymentMode = "Visa";
            }else if (order3.ismDebit()){
                paymentMode = "Debit";
            }else {
                paymentMode = "Cash";
            }
            textViewPayment3.setText("Payment Type: " + paymentMode);
        }else {
            textViewName3.setText("");
            textViewProduct3.setText("");
            textViewQuantity3.setText("");
            textViewPayment3.setText("");
            textViewTotalPrice3.setText("");
        }


    }

    public static void setOrdersList(ArrayList<Order> orders){
        ordersList = new ArrayList<Order>();
        ordersList = orders;
    }


}
