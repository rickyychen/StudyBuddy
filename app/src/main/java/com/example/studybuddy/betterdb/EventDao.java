package com.example.studybuddy.betterdb;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EventDao {

    @Query("SELECT * FROM events")
    List<Event> getAllEvents();

    @Query("SELECT * FROM events where eventid= :eventId")
    public Event getEventByID(long eventId);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertEvent(Event event);

    @Delete
    void deleteEvent(Event event);


}
