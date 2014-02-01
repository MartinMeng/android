package com.example.ex06_4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Button buttonArrayAdapter, buttonSimpleAdapter, buttonSimpleCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        buttonArrayAdapter = (Button) findViewById(R.id.ArrayAdapter);
        buttonArrayAdapter.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(this, arrayAdapter.class);
                startActivity(intent);
            }
        });
        
        buttonSimpleAdapter = (Button) findViewById(R.id.SimpleAdapter);
        buttonSimpleAdapter.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(this, SimpleAdapter.class);
                startActivity(intent);
            }
        });

        buttonSimpleCursorAdapter = (Button) findViewById(R.id.SimpleCursorAdapter);
        buttonSimpleCursorAdapter.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(this, SimpleCursorAdapter.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
