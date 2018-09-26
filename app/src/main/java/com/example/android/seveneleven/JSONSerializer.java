package com.example.android.seveneleven;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class JSONSerializer {
    private static String mFilename;
    private static Context mContext;

    private static ArrayList<Order> savingOrderList = new ArrayList<Order>();

    public JSONSerializer(String fn, Context con){
        mFilename = fn;
        mContext = con;
    }

//    public static void saveToList(Order ord) throws IOException, JSONException{
//        savingOrderList.add(ord);
//        save(savingOrderList);
//    }

    public static void save(List<Order> orders) throws IOException, JSONException {


// Make an array in JSON format
        JSONArray jArray = new JSONArray();
// And load it with the notes
        for (Order n : orders)
            jArray.put(n.convertToJSON());
// Now write it to the private disk space of our app
        Writer writer = null;
        try {
            OutputStream out = mContext.openFileOutput(mFilename, mContext.MODE_PRIVATE);
            writer = new OutputStreamWriter(out);
            writer.write(jArray.toString());
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    public ArrayList<Order> load() throws IOException, JSONException{
        ArrayList<Order> orderList = new ArrayList<Order>();
        BufferedReader reader = null;
        try {
            InputStream in = mContext.openFileInput(mFilename);
            reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder jsonString = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }
            JSONArray jArray = (JSONArray) new JSONTokener(jsonString.toString()).nextValue();
            for (int i = 0; i < jArray.length(); i++) {
                orderList.add(new Order(jArray.getJSONObject(i)));
            }
        } catch (FileNotFoundException e) {
// we will ignore this one, since it happens
// when we start fresh. You could add a log here.
        } finally {// This will always run
            if (reader != null)
                reader.close();
        }
        return orderList;
    }
}
