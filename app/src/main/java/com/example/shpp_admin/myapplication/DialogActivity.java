package com.example.shpp_admin.myapplication;

import android.app.DialogFragment;
import android.content.DialogInterface;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class DialogActivity extends DialogFragment implements OnClickListener {

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
        dismiss();
    }

    public void onDismiss (DialogInterface dialog) {
        super.onDismiss(dialog);
    }

    public void onCancel (DialogInterface dialog) {
        super.onCancel(dialog);
    }

}
