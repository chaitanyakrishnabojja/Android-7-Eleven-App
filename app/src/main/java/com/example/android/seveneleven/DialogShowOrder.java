package com.example.android.seveneleven;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class DialogShowOrder extends DialogFragment {

    private  Order mOrder;
    private Integer images[] = {R.drawable.dietcoke, R.drawable.pepsi, R.drawable.gatorade,
            R.drawable.frenchvenila, R.drawable.hotchocolate};
    private int getImage;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {



        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_show_order, null);

        TextView txtCustomerName = (TextView)dialogView.findViewById(R.id.txtCustomerName);
        TextView txtProductName = (TextView)dialogView.findViewById(R.id.txtProductName);
        TextView txtQuantity = (TextView)dialogView.findViewById(R.id.txtQuantity);
        TextView txtPaymentMode = (TextView)dialogView.findViewById(R.id.txtPaymentMode);
        TextView txtTotalPrice = (TextView)dialogView.findViewById(R.id.txtTotalPrice);
        ImageView imageView = (ImageView)dialogView.findViewById(R.id.imageView);

        if (mOrder.ismVisa()){
            txtPaymentMode.setText("Payment Mode: Visa");
        }
        else if (mOrder.ismDebit()){
            txtPaymentMode.setText("Payment Mode: Debit");
        }
        else if (mOrder.ismCash()){
            txtPaymentMode.setText("Payment Mode: Cash");
        }



        txtCustomerName.setText("Customer Name: " + mOrder.getmCustomerName());
        txtProductName.setText("Product Name: " + mOrder.getmProductName());
        txtQuantity.setText("Quantity: " + mOrder.getmQuantity());
        txtTotalPrice.setText("Total Price: "  + mOrder.getTotalPrice());
        ImageButton btnClose = (ImageButton)dialogView.findViewById(R.id.btnClose);



        builder.setView(dialogView).setMessage("Your Order");

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        if (mOrder.getmProductName().contains("Diet-Coke")){
            getImage = 0;
        }else if (mOrder.getmProductName().contains("pepsi")){
            getImage = 1;
        }else if (mOrder.getmProductName().contains("Gatorade")){
            getImage = 2;
        }else if (mOrder.getmProductName().contains("French Venila")){
            getImage = 3;
        }else if (mOrder.getmProductName().contains("Hot Chocolate")){
            getImage = 4;
        }

        imageView.setImageResource(images[getImage]);


        return  builder.create();
    }

    public void sendOrderSelected(Order o){
        mOrder = o;
    }

}
