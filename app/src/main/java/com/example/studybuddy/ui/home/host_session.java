package com.example.studybuddy.ui.home;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.studybuddy.MainActivity;
import com.example.studybuddy.R;
import com.example.studybuddy.betterdb.Event;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class host_session extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    String[] locations = {"McLennan", "Redpath", "McConell", "Trottier"};

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_session);

        Spinner spin = (Spinner) findViewById(R.id.spinner_location);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, locations);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

        DatePicker datepicker = (DatePicker) findViewById(R.id.datePicker1);
        int   day  = datepicker.getDayOfMonth();
        int   month= datepicker.getMonth();
        int   year = datepicker.getYear();
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String formatedDate = sdf.format(calendar.getTime());

        TimePicker timepicker = (TimePicker) findViewById(R.id.timePicker1);
        int hour = timepicker.getHour();
        int minute = timepicker.getMinute();

        String time = hour + ":" + minute;

        EditText description = (EditText) findViewById(R.id.description);
        String descriptionValue = description.getText().toString();

        final Button button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Event newEvent = new Event(eventId, formatedDate, time, descriptionValue);
                Intent intent = new Intent(host_session.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id){
        return;
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0){
        return;
    }
}