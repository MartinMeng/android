package com.example.ex5_3;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends Activity {

    private CheckBox cb1, cb2, cb3, cb4;
    private TextView tv1;
    private Button confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tv1 = (TextView) findViewById(R.id.tv);
        confirm = (Button) findViewById(R.id.bt);
        cb1 = (CheckBox) findViewById(R.id.checkBox1);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb3 = (CheckBox) findViewById(R.id.checkBox3);
        cb4 = (CheckBox) findViewById(R.id.checkBox4);
        
        confirm.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = "";
                if (cb1.isChecked()) {
                    result += (cb1.getText().toString() + '\n');
                }
                if (cb2.isChecked()) {
                    result += (cb2.getText().toString() + '\n');
                }
                if (cb3.isChecked()) {
                    result += (cb3.getText().toString() + '\n');
                }
                if (cb4.isChecked()) {
                    result += (cb4.getText().toString() + '\n');
                }
                tv1.setText(result);
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
