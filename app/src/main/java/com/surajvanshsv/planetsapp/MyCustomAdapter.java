package com.surajvanshsv.planetsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Planet> {

    private ArrayList<Planet> planetArrayList;
    Context context;

    public MyCustomAdapter(@NonNull Context context, ArrayList<Planet> planetArrayList) {
        super(context, R.layout.items_list_layout, planetArrayList);
        this.planetArrayList = planetArrayList;
        this.context = context;
    }

    private static class MyViewHolder{
        TextView planetName;
        TextView mooncount;
        ImageView planetImg;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Planet planet = getItem(position);

        MyViewHolder myViewHolder;
        final View result;

        if(convertView == null){
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.items_list_layout,
                    parent,
                    false
            );

            myViewHolder.planetName = (TextView) convertView.findViewById(R.id.planet_name);
            myViewHolder.mooncount = (TextView) convertView.findViewById(R.id.moon_count_id);
            myViewHolder.planetImg = (ImageView) convertView.findViewById(R.id.imageview);

            result = convertView;

            convertView.setTag(myViewHolder);

        } else {
            myViewHolder = (MyViewHolder) convertView.getTag();
            result = convertView;
        }
        myViewHolder.planetName.setText(planet.getPlanetName());
        myViewHolder.mooncount.setText(planet.getMoonCount());
        myViewHolder.planetImg.setImageResource(planet.getPlanetImage());
        return convertView;
    }
}
