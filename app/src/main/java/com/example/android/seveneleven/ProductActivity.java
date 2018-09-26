package com.example.android.seveneleven;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ProductActivity extends AppCompatActivity implements ActivityComs, CheckOutComs{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dualfragment);

        FragmentManager fManager= getFragmentManager();
        FragmentTransaction fTransaction= fManager.beginTransaction();
        Fragment frag = fManager.findFragmentById(R.id.listFragmentHolder);
        if (frag == null){
            frag = new ProductsListFragment();
            fTransaction.add(R.id.listFragmentHolder, frag)
                    .commit();
        }
    }

    public void onListItemSelected(int position) {
// Is there a layout with an id that matches the detail container?
        if (findViewById(R.id.detailFragmentHolder) == null) {
// If not we need to start a new activity
            Intent i = new Intent(this, PortraitDetailActivity.class);
// We can't pass an object in an intent.
// Neither do we want to.
// So we pass its position in the array list
            i.putExtra("Position", position);
            startActivity (i);
        } else {
// Fragment already exists
            FragmentManager fManager= getFragmentManager();
            FragmentTransaction fTransaction= fManager.beginTransaction();
            Fragment fragOld = fManager.findFragmentById(R.id.detailFragmentHolder);
            Fragment fragNew = ProductDetailFragment.newInstance(position);
            if (fragOld != null) {
                fTransaction.remove(fragOld);
            }
            fTransaction.add(R.id.detailFragmentHolder, fragNew);
            fTransaction.commit();
        }
    }

    public void onCheckOutClicked(String productName, double price){
        Intent checkOutIntent = new Intent(this, CheckOutActivity.class);
        checkOutIntent.putExtra("ProductName", productName);
        checkOutIntent.putExtra("Price", price);
        startActivity(checkOutIntent);
    }
}
