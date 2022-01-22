package com.example.studybuddy.databases;

public class EventDBHelper implements TableDB {

    public String create(){

        String query = "CREATE TABLE " +  "events_table" + " " +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + "event_name" + " TEXT, " +
        "location" + " TEXT, " + "description" + "TEXT, " + "event_class" + " TEXT, " +
        "event_datetime" + "DATETIME)  ";

        return query;

    }

    @Override
    public String addData() {
        return null;
    }

    @Override
    public String deleteData() {
        return null;
    }

    @Override
    public String updateData() {
        return null;
    }

    @Override
    public String mergeTable() {
        return null;
    }

    ;


}
