package com.example.shpp_admin.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class RightActivity extends AppCompatActivity{

    private String number;
    DialogFragment dlgCreation;

    SharedPreferences sharedPreferences;

    RecyclerView rv;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager manager;

    ArrayList<MissionStrings> missions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right);
        ImageButton buttonLeft2 = (ImageButton) findViewById(R.id.buttonLeft2);
        buttonLeft2.setOnClickListener(new View.OnClickListener() {

                                           @Override
                                           public void onClick(View v) {
                                               Intent intent = new Intent(RightActivity.this, MainActivity.class);
                                               startActivity(intent);
                                           }
                                       });

        number = getIntent().getStringExtra("class");

        dlgCreation = new DialogActivity();

        rv = (RecyclerView)findViewById(R.id.rv);
        manager = new LinearLayoutManager(this);
        rv.setLayoutManager(manager);
        initializeData();
        adapter = new RecyclerAdapter(missions);
        rv.setAdapter(adapter);
    }

    public void onCommitClick(View view) {
        EditText total = (EditText) findViewById(R.id.totalNumber);
        EditText days = (EditText) findViewById(R.id.totalDays);

        String totalString = total.getText().toString();
        String daysString = days.getText().toString();

        int totalInt, daysInt;
        if (totalString.equals("")) totalInt = 0;
        else totalInt = Integer.parseInt(totalString);
        if (daysString.equals("")) daysInt = 0;
        else daysInt = Integer.parseInt(daysString);

        if (daysInt > 0)
            number = String.valueOf(totalInt/daysInt);
        else
            number = "empty";

        Intent intent = new Intent(RightActivity.this, MainActivity.class);
        intent.putExtra("class", number);
        startActivity(intent);
    }

    public void onClick(View view) {
        dlgCreation.show(getFragmentManager(), "dlgCreation");
    }

    private void initializeData() {
        missions = new ArrayList<>();

        sharedPreferences = getSharedPreferences("MISSIONS_INT", MODE_PRIVATE);
        int arrayLength = sharedPreferences.getInt("MISSIONS_INT", 0);

        Gson gson = new GsonBuilder().create();

        for (int i = 0; i < arrayLength; i++) {
            String MISSION = "MISSIONS_" + (i+1);

            sharedPreferences = getSharedPreferences(MISSION, MODE_PRIVATE);
            String mission = sharedPreferences.getString(MISSION, "Empty");

            MissionStrings missionStrings = gson.fromJson(mission, MissionStrings.class);
            missions.add(missionStrings);
        }
    }


//    activity lifecycle
//    extends/implements
//    recycler view
}
