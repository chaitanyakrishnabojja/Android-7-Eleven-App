package com.example.android.seveneleven;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class OrdersListActivity extends AppCompatActivity {

    private JSONSerializer mSerializer;
    private OrderAdapter mOrderAdapter;
    private Integer images[] = {R.drawable.dietcoke, R.drawable.pepsi, R.drawable.gatorade,
            R.drawable.frenchvenila, R.drawable.hotchocolate};
    private int getImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_list);


        mOrderAdapter = new OrderAdapter();

        ListView listOrder = (ListView)findViewById(R.id.listView);
        listOrder.setAdapter(mOrderAdapter);

        listOrder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int whichItem, long id) {
                Order tempOrder = mOrderAdapter.getItem(whichItem);
                DialogShowOrder dialog = new DialogShowOrder();
                dialog.sendOrderSelected(tempOrder);
                dialog.show(getFragmentManager(), "123");

            }
        });

    }
    public class OrderAdapter extends BaseAdapter {

        ArrayList<Order> orderList = new ArrayList<Order>();

        public OrderAdapter(){
            mSerializer = new JSONSerializer("OrdersDataBase.json", OrdersListActivity.this.getApplicationContext());
            Log.e("Order Adapter", "loaded");
//            orderList = LoadedOrderData.getOrderArrayList();
            try {
                orderList = mSerializer.load();
            } catch (Exception e) {
                orderList = new ArrayList<Order>();
                Log.e("Error loading notes: ", "", e);
            }

        }

        @Override
        public int getCount() {
            return orderList.size();
        }

        @Override
        public Order getItem(int whichItem) {
            return orderList.get(whichItem);
        }

        @Override
        public long getItemId(int whichItem) {
            return whichItem;
        }

        @Override
        public View getView(int whichItem, View view, ViewGroup viewGroup) {

            if (view == null){
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.order_list_item, viewGroup, false);
            }

            TextView txtCustomerName = (TextView)view.findViewById(R.id.txtCustomerName);
            TextView txtProductName = (TextView)view.findViewById(R.id.txtProductName);
            TextView txtQuantity = (TextView)view.findViewById(R.id.txtQuantity);
            TextView txtPaymentMode = (TextView)view.findViewById(R.id.txtPaymentMode);
            TextView txtTotalPrice = (TextView)view.findViewById(R.id.txtTotalPrice);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);

            Order tempOrder = orderList.get(whichItem);

            txtCustomerName.setText("Cust Name: " + tempOrder.getmCustomerName());
            txtProductName.setText("Product Name: " + tempOrder.getmProductName());
            txtQuantity.setText("Quantity: " + tempOrder.getmQuantity());
            txtTotalPrice.setText("Total Price: " + tempOrder.getTotalPrice());

            if(tempOrder.ismVisa()){
                txtPaymentMode.setText("Payment Mode: Visa");
            }
            else if(tempOrder.ismDebit()){
                txtPaymentMode.setText("Payment Mode: Debit");
            }
            else if(tempOrder.ismCash()){
                txtPaymentMode.setText("Payment Mode: Cash");
            }


            if (tempOrder.getmProductName().contains("Diet-Coke")){
                getImage = 0;
            }else if (tempOrder.getmProductName().contains("pepsi")){
                getImage = 1;
            }else if (tempOrder.getmProductName().contains("Gatorade")){
                getImage = 2;
            }else if (tempOrder.getmProductName().contains("French Venila")){
                getImage = 3;
            }else if (tempOrder.getmProductName().contains("Hot Chocolate")){
                getImage = 4;
            }
            Log.e("tempOrder Name", "" + tempOrder.getmProductName());
            Log.e("getImage", "" + getImage);

            imageView.setImageResource(images[getImage]);


            return view;
        }


    }
}
