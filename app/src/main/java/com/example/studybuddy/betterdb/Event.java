package com.example.studybuddy.betterdb;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "events")
public class Event {

    @PrimaryKey
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

    public Event(long eventId, String eventName, String eventDate, String eventTime, String eventDescription){
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventDescription = eventDescription;
    }



//    @ColumnInfo(name = "time")
//    //find way to implement time
//    @ColumnInfo(name = "date")
//    //find way to implement date

}
