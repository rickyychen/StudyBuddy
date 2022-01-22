package com.example.studybuddy.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.metrics.Event;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String STUDY_BUDDY_DB = "StudyBuddy.db";

    public static CourseDBHelper coursesTable = new CourseDBHelper();
    public static EventDBHelper eventsTable = new EventDBHelper();
    public static StudentDBHelper studentsTable = new StudentDBHelper();
//    public static final String CLASSES_TABLE = "classes_table";
//    public static final String CLASS_NAME = "class_name";

    public DatabaseHelper(@Nullable Context context) {
        super(context, STUDY_BUDDY_DB, null, 1);
    }

    //first time a database is accessed. Generate table if necessary
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createStudentStatement  = "";
        String createEventStatement = "";
        db.execSQL(createEventStatement);
    }

    // Called if the database version number changes. Prevents prev. users apps from breaking when
    // you change the database.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }


}
