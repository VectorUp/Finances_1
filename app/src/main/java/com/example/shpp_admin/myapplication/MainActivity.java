package com.example.shpp_admin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton buttonRight = (ImageButton) findViewById(R.id.buttonRight);
        buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RightActivity.class);
                startActivity(intent);
            }
        });
        ImageButton buttonLeft = (ImageButton) findViewById(R.id.buttonLeft);
        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LeftActivity.class);
                startActivity(intent);
            }
        });
        // Ввод текста с выводом при нажатии Enter
        /*final EditText editText = (EditText)findViewById(R.id.EditTextNumber);
        editText.setOnKeyListener(new View.OnKeyListener()
        {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    String moneyTotal = editText.getText().toString();

                    if (editText.getText().toString().equals(""))
                        textView.setText("empty");
                    else
                        textView.setText(moneyTotal);

                    return true;
                }
                return false;
            }
        });*/

        textView = (TextView)findViewById(R.id.TextViewSumm);
        //String totalAmount;

        //if(getIntent().getExtras().getString("per_day") != null)
        //    totalAmount = getIntent().getExtras().getString("per_day");
       // else
         //   totalAmount = "empty";

        //textView.setText(totalAmount);
    }
        //jmyujmum
        // gitignore
    }


