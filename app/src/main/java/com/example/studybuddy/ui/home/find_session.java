package com.example.studybuddy.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.studybuddy.MainActivity;
import com.example.studybuddy.R;

public class find_session extends AppCompatActivity {
    //private Button host;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_session);


        //host = findViewById(R.id.button);
        //host.setOnClickListener(new View.OnClickListener() {
        //   public void onClick(View v) {
        //     Intent intent = new Intent(find_session.this, join.class);
        //      startActivity(intent);
    }

    public void proceed(View v){
        Intent i = new Intent(find_session.this, join.class);
        startActivity(i);

            }
        //});

}