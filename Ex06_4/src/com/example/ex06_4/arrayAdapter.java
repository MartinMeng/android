package com.example.ex06_4;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;

public class arrayAdapter extends Activity {

    ListView listView;
    ArrayAdapter<String> adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arrayadapter);
        
        listView = (ListView) findViewById(R.id.arrayList);
        String[] weekList = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
                "Saturday", "Sunday" };
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, weekList);
        listView.setAdapter(adapter);
    }
}
