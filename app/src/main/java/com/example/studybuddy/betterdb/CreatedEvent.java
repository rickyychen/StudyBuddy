package com.example.studybuddy.betterdb;

import androidx.room.Entity;

// based off the Enrolled Courses class
@Entity(primaryKeys = {"id", "eventId"})
public class CreatedEvent {

    public long id;
    public long eventId;
}
