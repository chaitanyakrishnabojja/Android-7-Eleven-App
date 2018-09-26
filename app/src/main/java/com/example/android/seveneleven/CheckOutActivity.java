package com.example.android.seveneleven;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class CheckOutActivity extends AppCompatActivity {

    private JSONSerializer mSerializer;
    private int quantity;
    private String totalPrice;
    private ArrayList<Order> orderArrayList = new ArrayList<Order>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        mSerializer = new JSONSerializer("OrdersDataBase.json", CheckOutActivity.this.getApplicationContext());

        final EditText editTextName = (EditText)findViewById(R.id.editTextName);
        final TextView txtProductName = (TextView)findViewById(R.id.txtProductName);
        final TextView txtQuantity = (TextView) findViewById(R.id.txtQuantity);
        final TextView txtTotalPrice = (TextView)findViewById(R.id.txtTotalPrice);
        final RadioButton rdoBtnVisa = (RadioButton)findViewById(R.id.rdoBtnVisa);
        final RadioButton rdoBtnDebit = (RadioButton)findViewById(R.id.rdoBtnDebit);
        final RadioButton rdoBtnCash = (RadioButton)findViewById(R.id.rdoBtnCash);
        Button btnConfirmOrder = (Button)findViewById(R.id.btnConfirmOrder);
        Button btnCancel = (Button)findViewById(R.id.btnCancel);
        ImageButton btnAdd = (ImageButton)findViewById(R.id.btnAdd);
        ImageButton btnSubtract = (ImageButton)findViewById(R.id.btnSubtract);


        Intent i = getIntent();
        String productName = i.getStringExtra("ProductName");
        final double price = i.getExtras().getDouble("Price");
        txtProductName.setText(productName + "(1/$" + price + ")");
        quantity = 1;
        txtQuantity.setText("" + quantity);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity++;
               totalPrice = quantity + " x " + price + " = " + (quantity * price);
                txtQuantity.setText("" + quantity);
                txtTotalPrice.setText("Total: " + totalPrice);
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity == 0){

                }else {
                    quantity--;
                    totalPrice = quantity + " x " + price + " = " + (quantity * price);
                    txtQuantity.setText("" + quantity);
                    txtTotalPrice.setText("Total: " + totalPrice);
                }

            }
        });



        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivityIntent = new Intent(CheckOutActivity.this, MainActivity.class);
                startActivity(mainActivityIntent);
            }
        });

        btnConfirmOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Order newOrder = new Order();
                newOrder.setmCustomerName(editTextName.getText().toString());
                newOrder.setmProductName(txtProductName.getText().toString());
                int quantity = Integer.parseInt(txtQuantity.getText().toString());
                newOrder.setmQuantity(quantity);
                newOrder.setTotalPrice(quantity * price);
                newOrder.setmVisa(rdoBtnVisa.isChecked());
                newOrder.setmDebit(rdoBtnDebit.isChecked());
                newOrder.setmCash(rdoBtnCash.isChecked());


                try{
//                    orderArrayList = new ArrayList<Order>(); // for clearing JSON arraylist
                    orderArrayList = mSerializer.load();
                    orderArrayList.add(newOrder);
                    JSONSerializer.save(orderArrayList);
                }catch(Exception e){
                    Log.e("Error Saving Notes","", e);

                }


                Intent  MainActivityIntent= new Intent(CheckOutActivity.this, MainActivity.class);
                startActivity(MainActivityIntent);
            }
        });

        Button btnPreviousOrders = (Button)findViewById(R.id.btnPreviousOrders);
        btnPreviousOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(CheckOutActivity.this, OrdersListActivity.class);
                startActivity(i);
            }
        });

    }
}
