package com.example.studybuddy.ui.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.studybuddy.R;
import com.example.studybuddy.betterdb.Event;

import java.util.ArrayList;
import java.util.List;

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

    public static class SessionViewHolder extends RecyclerView.ViewHolder{

        private TextView session_name;

        public SessionViewHolder(@NonNull View itemView) {
            super(itemView);
            session_name = (TextView) ViewCompat.requireViewById(itemView, R.id.session_name);
        }

        public void bind(Event event){
            session_name.setText(event.eventName);

        }
    }

}