package com.example.studybuddy.databases;

public class CourseDBHelper implements TableDB {

    private static final String STUDY_BUDDY_DB = "StudyBuddy.db";
    private static final String CLASSES_TABLE = "classes_table";
    private static final String CLASS_NAME = "class_name";

    @Override
    public String create(){

        String query = "CREATE TABLE " +  CLASSES_TABLE + " " +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + CLASS_NAME + " TEXT) ";
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
