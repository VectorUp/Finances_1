package com.example.shpp_admin.myapplication;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shpp_admin.myapplication.MissionStrings;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView missionCategory;
        TextView missionName;
        TextView missionValue;
        TextView missionDeadline;

        ViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            missionCategory = (TextView)itemView.findViewById(R.id.textCategory);
            missionName = (TextView)itemView.findViewById(R.id.textName);
            missionValue = (TextView)itemView.findViewById(R.id.textValue);
            missionDeadline = (TextView)itemView.findViewById(R.id.textDeadline);
        }
    }

    List<MissionStrings> missions;

    RecyclerAdapter(List<MissionStrings> missions) {
        this.missions = missions;
    }

    @Override
    public void onViewAttachedToWindow(ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.missionCategory.setText(missions.get(position).category);
        holder.missionName.setText(missions.get(position).name);
        holder.missionValue.setText(missions.get(position).value);
        holder.missionDeadline.setText(missions.get(position).deadline);
    }

    @Override
    public int getItemCount() {
        return missions.size();
    }
}