package com.example.shpp_admin.myapplication;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RightActivity extends AppCompatActivity{

    private String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right);

        number = getIntent().getStringExtra("class");
    }

    public void onCommitClick(View view) {
        EditText total = (EditText) findViewById(R.id.totalNumber);
        EditText days = (EditText) findViewById(R.id.totalDays);


        int totalInt = Integer.parseInt(total.getText().toString());
        int daysInt = Integer.parseInt(days.getText().toString());

        if (days.getText().equals(""))
            daysInt = 0;
        if (total.getText().equals(""))
            totalInt = 0;

        if (daysInt > 0)
            number = String.valueOf(totalInt/daysInt);
        else
            number = "empty";

        Intent intent = new Intent(RightActivity.this, MainActivity.class);
        intent.putExtra("class", number);
        startActivity(intent);
    }

    public void onClick(View view) {
        Intent intent = new Intent(RightActivity.this, AddNewActivity.class);
        startActivity(intent);
    }


//    activity lifecycle
//    extends/implements
//    recycler view
}
