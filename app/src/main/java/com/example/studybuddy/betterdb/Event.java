package com.example.studybuddy.betterdb;

import androidx.navigation.NavDestination;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "events")
public class Event {

    @PrimaryKey
    public long eventId;
    @ColumnInfo(name = "eventname")
    public String eventName;
//    @ColumnInfo(name = "time")
//    //find way to implement time
//    @ColumnInfo(name = "date")
//    //find way to implement date

}
