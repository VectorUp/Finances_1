package com.example.shpp_admin.myapplication;

import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DialogActivity extends DialogFragment implements OnClickListener {

    String MISSIONS = "MISSIONS";
    SharedPreferences mCharacters;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {

        getDialog().setTitle("Create new mission");
        // Подключаем основной контент диалогового окна (компоненты созданой миссии)
        View view = inflater.inflate(R.layout.dialog_mine, null);
        // Подключаем кнопки создания и отмены
        view.findViewById(R.id.buttonCreate).setOnClickListener(this);
        view.findViewById(R.id.buttonCancel).setOnClickListener(this);

        return view;
    }

    public void onClick (View view) {
        switch (view.getId()) {
            case R.id.buttonCreate:

                mCharacters = this.getActivity().getSharedPreferences("MISSIONS_INT", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = mCharacters.edit();
                if (mCharacters.getInt("MISSIONS_INT", 0) != 0) {
                    int i = mCharacters.getInt("MISSIONS_INT", 0) + 1;
                    editor.putInt("MISSIONS_INT", i);
                }
                else
                    editor.putInt("MISSIONS_INT", 1);
                editor.apply();

                MISSIONS = "MISSIONS_" + mCharacters.getInt("MISSIONS_INT", 0);

                mCharacters = this.getActivity().getSharedPreferences(MISSIONS, Context.MODE_PRIVATE);

                EditText editCategory = (EditText) getDialog().findViewById(R.id.missionCategory);
                EditText editName = (EditText) getDialog().findViewById(R.id.missionName);
                EditText editValue = (EditText) getDialog().findViewById(R.id.missionValue);
                EditText editDeadline = (EditText) getDialog().findViewById(R.id.missionDeadline);

                String category = editCategory.getText().toString();
                String name = editName.getText().toString();
                String value = editValue.getText().toString();
                String deadline = editDeadline.getText().toString();

                MissionStrings characters = new MissionStrings(category, name,value, deadline);

                Gson gson = new GsonBuilder().create();

                String stringCharacters = gson.toJson(characters, MissionStrings.class);

                editor = mCharacters.edit();
                editor.putString(MISSIONS, stringCharacters);
                editor.apply();

                break;
            default:
                break;
        }

        dismiss();
    }

    public void onDismiss (DialogInterface dialog) {
        super.onDismiss(dialog);
    }

    public void onCancel (DialogInterface dialog) {
        super.onCancel(dialog);
    }

}
