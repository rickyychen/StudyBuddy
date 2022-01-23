package com.example.studybuddy.ui.home;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.studybuddy.MainActivity;
import com.example.studybuddy.R;

import java.util.Date;

public class host_session extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    String[] locations = {"McLennan", "Redpath", "McConell", "Trottier"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_session);

        final Button button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(host_session.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Spinner spin = (Spinner) findViewById(R.id.spinner_location);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, locations);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

        DatePicker datepicker = (DatePicker) findViewById(R.id.datePicker1);
        TimePicker timepicker = (TimePicker) findViewById(R.id.timePicker1);

        EditText description = (EditText) findViewById(R.id.description);
        String descriptionValue = description.getText().toString();
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