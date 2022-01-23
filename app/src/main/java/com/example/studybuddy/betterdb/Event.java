package com.example.studybuddy.betterdb;

import androidx.navigation.NavDestination;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(tableName = "events")
public class Event {

    @PrimaryKey
    public long eventId;
    @ColumnInfo(name = "eventname")
    public String eventName;
    @ColumnInfo(name = "eventdate")
    public String eventDate;
    @ColumnInfo(name = "eventtime")
    public String EventTime;



//    @ColumnInfo(name = "time")
//    //find way to implement time
//    @ColumnInfo(name = "date")
//    //find way to implement date

}
