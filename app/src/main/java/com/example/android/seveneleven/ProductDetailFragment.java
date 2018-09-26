package com.example.android.seveneleven;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductDetailFragment extends Fragment {

    private CheckOutComs mCheckOutComs;
    private ArrayList<NameAndDescription> mNamesAndDescriptions;
    private NameAndDescription mCurrentNameAndDescription;

    private Integer images[] = {R.drawable.dietcoke, R.drawable.pepsi, R.drawable.gatorade,
            R.drawable.frenchvenila, R.drawable.hotchocolate};
    private static int imagePosition;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNamesAndDescriptions = ModelProducts.getInstance().getProducts();
// Get the position from the Bundle
// using the constant string
        int position = (int)getArguments().getInt("Position");
// Initialize with the current name and address
        mCurrentNameAndDescription = mNamesAndDescriptions.get(position);
    }

    public static ProductDetailFragment newInstance(int position) {
        imagePosition = position;
        Bundle args = new Bundle();
        args.putInt("Position", position);
        ProductDetailFragment frag = new ProductDetailFragment();
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_fragment, container, false);
        final TextView txtName = (TextView) view.findViewById(R.id.txtName);
        TextView txtDescription = (TextView) view.findViewById(R.id.txtDescription);
        TextView txtCategory = (TextView) view.findViewById(R.id.txtCategory);
        TextView txtPrice = (TextView) view.findViewById(R.id.txtPrice);
        Button btnCheckOut = (Button)view.findViewById(R.id.btnCheckOut);

        btnCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCheckOutComs.onCheckOutClicked(mCurrentNameAndDescription.getName(), mCurrentNameAndDescription.getPrice());

            }
        });

        txtName.setText(mCurrentNameAndDescription.getName());
        txtDescription.setText("Desc: " + mCurrentNameAndDescription.getDescription());
        txtCategory.setText("Category: " + mCurrentNameAndDescription.getCategory());
        txtPrice.setText("Price: $" + Double.toString(mCurrentNameAndDescription.getPrice()));

            final ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            imageView.setImageResource(images[imagePosition]);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
/*
activity is a ActivityComs but must
still be explicitly cast to the type
*/
        mCheckOutComs = (CheckOutComs) activity;
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mCheckOutComs = null;
    }


}
