package com.example.studybuddy.ui.home;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.studybuddy.Database;
import com.example.studybuddy.MainActivity;
import com.example.studybuddy.R;
import com.example.studybuddy.betterdb.CoursesWithEventsDao;
import com.example.studybuddy.betterdb.CreatedEvent;
import com.example.studybuddy.betterdb.Event;
import com.example.studybuddy.betterdb.EventDao;
import com.example.studybuddy.betterdb.Student;
import com.example.studybuddy.betterdb.StudentDao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class host_session extends AppCompatActivity{

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_session);

        final Button button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                DatePicker datepicker = (DatePicker) findViewById(R.id.datePicker1);
                int day = datepicker.getDayOfMonth();
                int month = datepicker.getMonth();
                int year = datepicker.getYear();
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
                EditText study = (EditText) findViewById(R.id.name);
                String studyName = study.getText().toString();
                EditText location = (EditText) findViewById(R.id.location);
                String locationValue = location.getText().toString();

                System.out.println(locationValue);
                Executor executor = Executors.newSingleThreadExecutor();
                executor.execute(new Runnable() {
                    @Override
                    public void run() {

                        Database dbtool = Room.databaseBuilder(getApplicationContext(), Database.class, "StudyBuddy").build();

                        StudentDao studentDao = dbtool.getStudentDao();
                        final List<Student> students = studentDao.getAllStudents();
                        Student studMuffin = students.get(0);

                        Event newEvent = new Event(studyName, formatedDate, time, descriptionValue, locationValue);
                        EventDao eventDao = dbtool.getEventDao();

                        CoursesWithEventsDao coursesWithEventsDao = dbtool.getCoursesWithEventsDao();
                        CreatedEvent createdEvent = new CreatedEvent();
                        createdEvent.eventId = newEvent.eventId;
                        createdEvent.id = studMuffin.ActiveCourse;
                        coursesWithEventsDao.insert(createdEvent);


                    }
                });

                Intent intent = new Intent(host_session.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}