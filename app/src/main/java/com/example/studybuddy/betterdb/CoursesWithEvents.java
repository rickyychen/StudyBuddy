package com.example.studybuddy.betterdb;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class CoursesWithEvents {

    @Embedded
    public Course course; //c

    @Relation(
            parentColumn = "id", //f
            entityColumn = "eventId", //f
            entity = Event.class, //c
            associateBy = @Junction(CreatedEvent.class)

    )
    public List<Event> EnrolledEvents;
}
