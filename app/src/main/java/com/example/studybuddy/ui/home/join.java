package com.example.studybuddy.ui.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.studybuddy.Database;
import com.example.studybuddy.R;
import com.example.studybuddy.betterdb.CoursesWithEvents;
import com.example.studybuddy.betterdb.CoursesWithEventsDao;
import com.example.studybuddy.betterdb.CreatedEvent;
import com.example.studybuddy.betterdb.Event;
import com.example.studybuddy.betterdb.EventDao;
import com.example.studybuddy.betterdb.Student;
import com.example.studybuddy.betterdb.StudentDao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class join extends AppCompatActivity {
    private RecyclerView current_sessions;
    private SessionAdapter adapter = new SessionAdapter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        current_sessions = (RecyclerView) ActivityCompat.requireViewById(this, R.id.rvEvents);
        final LinearLayoutManager linear =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        current_sessions.setLayoutManager(linear);
        current_sessions.setAdapter(adapter);
    }

    public class SessionAdapter extends RecyclerView.Adapter<SessionViewHolder>{

        private List<Event> events = new ArrayList<>();

        public void updateEvents(List<Event> newEvents){
            events.clear();
            events.addAll(newEvents);
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public SessionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new SessionViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_session, parent));

        }

        @Override
        public void onBindViewHolder(@NonNull SessionViewHolder holder, int position) {
            holder.bind(events.get(position));
        }

        @Override
        public int getItemCount() {
            return events.size();
        }
    }

    public class SessionViewHolder extends RecyclerView.ViewHolder{

        private TextView session_name;
        private TextView session_location;
        private TextView session_description;
        private TextView session_time;

        public SessionViewHolder(@NonNull View itemView) {
            super(itemView);
            session_name = (TextView) ViewCompat.requireViewById(itemView, R.id.session_name);
            session_location = (TextView) ViewCompat.requireViewById(itemView, R.id.session_name);
            session_description = (TextView) ViewCompat.requireViewById(itemView, R.id.session_description);
            session_time = (TextView) ViewCompat.requireViewById(itemView, R.id.session_time);

        }

        public void bind(Event event){
            Executor executor = Executors.newSingleThreadExecutor();
            executor.execute(new Runnable() {
                @Override
                public void run() {

                    Database dbtool = Room.databaseBuilder(getApplicationContext(), Database.class, "StudyBuddy").build();
                    EventDao eventDao = dbtool.getEventDao();
                    Event eventDisplay = eventDao.getEventByID(event.eventId);

                    session_name.setText(eventDisplay.eventName);
                    session_location.setText(eventDisplay.eventLocation);
                    session_description.setText(eventDisplay.eventDescription);
                    session_time.setText(eventDisplay.eventTime);

                }
            });


        }
    }

}