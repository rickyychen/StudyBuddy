package com.example.studybuddy.databases;

public class CourseDBHelper {

    private static final String STUDY_BUDDY_DB = "StudyBuddy.db";
    private static final String CLASSES_TABLE = "classes_table";
    private static final String CLASS_NAME = "class_name";

    public static String main(){

        String query = "CREATE TABLE " +  CLASSES_TABLE + " " +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + CLASS_NAME + " TEXT) ";
        return query;

    };
}
