package com.example.studybuddy.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.studybuddy.MainActivity;
import com.example.studybuddy.R;

public class find_session extends AppCompatActivity {
    //private Button host;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_session);
        Intent i = getIntent();
        String course = i.getStringExtra("COURSE");
        ((TextView)findViewById(R.id.textView2)).setText(course);

    }

    public void proceed(View v){
        Intent i = new Intent(find_session.this, join.class);
        startActivity(i);

            }


}