package com.example.studybuddy.databases;

public class EventDBHelper {

    public static String main(){

        String query = "CREATE TABLE " +  "events_table" + " " +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + "event_name" + " TEXT, " +
        "location" + " TEXT, " + "description" + "TEXT, " + "event_class" + " TEXT, " +
        "event_datetime" + "DATETIME)  ";

        return query;

    };


}
