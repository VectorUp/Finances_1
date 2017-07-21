package com.example.shpp_admin.myapplication;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RightActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right);
    }


    public void onCommitClick(View view) {
        EditText total = (EditText) findViewById(R.id.totalNumber);
        EditText days = (EditText) findViewById(R.id.totalDays);
        int totalInt = Integer.parseInt(total.getText().toString());
        int daysInt = Integer.parseInt(days.getText().toString());
        int perDay;

        if (daysInt > 0)
            perDay = (totalInt/daysInt);
        else
            perDay = 0;

        Intent intent = new Intent(RightActivity.this, MainActivity.class);
        intent.putExtra("per_day", perDay);

        startActivity(intent);
    }


//    activity lifecycle
//    extends/implements
//    recycler view
}
