package com.example.android.seveneleven;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PortraitDetailActivity extends AppCompatActivity implements CheckOutComs {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portrait_detail);
        Button btnCheckOut = (Button)findViewById(R.id.btnCheckOut);


        FragmentManager fManager = getFragmentManager();
// Create a new fragment using the manager
// Passing in the id of the layout to hold it
        Fragment frag = fManager.findFragmentById(R.id.detailFragmentHolder);
// Pass the Bundle onto the fragment
        int position = 0;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            position = extras.getInt("Position");
        }
// Check the fragment has not already been initialized
        if(frag == null){
            frag = ProductDetailFragment.newInstance(position);
            fManager.beginTransaction()
                    .add(R.id.detailFragmentHolder, frag)
                    .commit();
        }

    }

    public void onCheckOutClicked(String productName, double price){
        Intent checkOutIntent = new Intent(this, CheckOutActivity.class);
        checkOutIntent.putExtra("ProductName", productName);
        checkOutIntent.putExtra("Price", price);
        startActivity(checkOutIntent);
    }


}
