package com.example.kitsune;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomAdapter extends ArrayAdapter<HashMap<String, String>> {

    public CustomAdapter(Context context, ArrayList<HashMap<String, String>> dataList) {
        super(context, 0, dataList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        HashMap<String, String> item = getItem(position);
        if (item != null) {
            TextView name = view.findViewById(R.id.displayName);
            TextView description = view.findViewById(R.id.displayDescription);
            TextView duration = view.findViewById(R.id.displayDuration);
            TextView intensity = view.findViewById(R.id.displayIntensity);
            TextView exercise1 = view.findViewById(R.id.displayExercise1);
            TextView exercise2 = view.findViewById(R.id.displayExercise2);
            TextView exercise3 = view.findViewById(R.id.displayExercise3);
            TextView exercise4 = view.findViewById(R.id.displayExercise4);
            TextView exercise5 = view.findViewById(R.id.displayExercise5);

            name.setText(item.get("title"));
            description.setText(item.get("description"));
            duration.setText("Duration: " + item.get("duration"));
            intensity.setText("Intensity: " + item.get("intensity"));
            exercise1.setText(item.get("exercise1"));
            exercise2.setText(item.get("exercise2"));
            exercise3.setText(item.get("exercise3"));
            exercise4.setText(item.get("exercise4"));
            exercise5.setText(item.get("exercise5"));
        }

        return view;
    }
}


