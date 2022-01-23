package com.example.studybuddy.betterdb;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "events")
public class Event {

    @PrimaryKey(autoGenerate = true)
    public long eventId;
    @ColumnInfo(name = "eventname")
    public String eventName;
    @ColumnInfo(name = "eventdate")
    public String eventDate;
    @ColumnInfo(name = "eventtime")
    public String eventTime;
    @ColumnInfo(name = "eventdescription")
    public String eventDescription;
    @ColumnInfo(name = "eventlocation")
    public String eventLocation;

    public Event(String eventName, String eventDate, String eventTime, String eventDescription, String eventLocation){
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventDescription = eventDescription;
        this.eventLocation = eventLocation;

    }



//    @ColumnInfo(name = "time")
//    //find way to implement time
//    @ColumnInfo(name = "date")
//    //find way to implement date

}
