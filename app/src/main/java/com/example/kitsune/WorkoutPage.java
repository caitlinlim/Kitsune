package com.example.kitsune;

import android.app.AlertDialog;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.kitsune.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class WorkoutPage extends AppCompatActivity {



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_list);

        TextView textView = findViewById(R.id.workoutsTitle);
        Button scheduleButton = findViewById(R.id.scheduleButton);
        Button createButton = findViewById(R.id.createButton);
        ListView listViewWorkouts = findViewById(R.id.listViewWorkouts);

        ArrayList<HashMap<String, String>> dataList = new ArrayList<>();

        HashMap<String, String> item1 = new HashMap<>();
        item1.put("title", "Arm Workout");
        item1.put("description", "Workout targeting arm muscles");
        item1.put("duration", "30");
        item1.put("intensity", "5/5");
        item1.put("exercise1", "Bicep Curls");
        item1.put("exercise2", "Tricep Dips");
        item1.put("exercise3", "Hammer Curls");
        item1.put("exercise4", "Tricep Pushdowns");
        item1.put("exercise5", "Dumbbell Rows");
        dataList.add(item1);


        HashMap<String, String> item2 = new HashMap<>();
        item2.put("title", "Leg Workout");
        item2.put("description", "Workout targeting leg muscles");
        item2.put("duration", "20");
        item2.put("intensity", "3/5");
        item2.put("exercise1", "Squats");
        item2.put("exercise2", "Leg Press");
        item2.put("exercise3", "Lunges");
        item2.put("exercise4", "Deadlifts");
        item2.put("exercise5", "");
        dataList.add(item2);

        HashMap<String, String> item3 = new HashMap<>();
        item3.put("title", "Back Workout");
        item3.put("description", "Workout targeting back muscles");
        item3.put("duration", "25");
        item3.put("intensity", "4/5");
        item3.put("exercise1", "Pull-ups");
        item3.put("exercise2", "Bent-over rows");
        item3.put("exercise3", "Lat pulldowns");
        item3.put("exercise4", "Deadlifts");
        item3.put("exercise5", "");
        dataList.add(item3);

        CustomAdapter adapter = new CustomAdapter(this, dataList);
        listViewWorkouts.setAdapter(adapter);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showWorkoutDialog();
            }
        });

        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showScheduleDialog();
            }
        });
    }

    private void showWorkoutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Create Workout");

        // Inflate the custom dialog layout
        View dialogView = getLayoutInflater().inflate(R.layout.create_workout, null);
        builder.setView(dialogView);

        EditText editWorkoutName = dialogView.findViewById(R.id.editTextWorkoutName);
        EditText editWorkoutDescription = dialogView.findViewById(R.id.editTextWorkoutDescription);
        EditText editWorkoutDuration = dialogView.findViewById(R.id.editTextWorkoutDuration);

        // Set positive and negative buttons
        builder.setPositiveButton("OK", (dialog, which) -> {
            String name = editWorkoutName.getText().toString();
            String email = editWorkoutDescription.getText().toString();
            String duration = editWorkoutDuration.getText().toString();

            // Do something with the entered values
            Toast.makeText(WorkoutPage.this, "Workout created", Toast.LENGTH_SHORT).show();
        });
        builder.setNegativeButton("Cancel", null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showScheduleDialog() {
        HashMap<String, String> dateInformationMap = new HashMap<>();

        // Add information for a specific date
        String date = "2023-7-20";
        String information = "Arm Workout";
        dateInformationMap.put(date, information);

        // Add information for another date
        date = "2023-7-22";
        information = "Leg Workout.";
        dateInformationMap.put(date, information);

        date = "2023-7-23";
        information = "Back Workout.";
        dateInformationMap.put(date, information);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("View Schedule");

        // Inflate the custom dialog layout
        View dialogView = getLayoutInflater().inflate(R.layout.workout_schedule, null);

        CalendarView workoutSchedule = dialogView.findViewById(R.id.workoutCalendarView);
        workoutSchedule.setDate(System.currentTimeMillis());

        workoutSchedule.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int dayOfMonth) {
                // Customize the code below to retrieve the information for the selected date
                String selectedDate = year + "-" + (month + 1) + "-" + dayOfMonth;
                String information = dateInformationMap.get(selectedDate);

                if (information != null) {
                    Toast.makeText(WorkoutPage.this, information, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(WorkoutPage.this, "No information available for this date.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setView(dialogView);

        // Set positive and negative buttons
        builder.setPositiveButton("OK", null);
        builder.setNegativeButton("Cancel", null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}