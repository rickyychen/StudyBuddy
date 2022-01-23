package com.example.studybuddy.ui.home;

import android.content.DialogInterface;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
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

        Button host_button = (Button) findViewById(R.id.button2);
        host_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(find_session.this, host_session.class);
                startActivity(intent);
            }
        });

    }

    public void proceed(View v){
        Intent i = new Intent(find_session.this, join.class);
        startActivity(i);

    }


}