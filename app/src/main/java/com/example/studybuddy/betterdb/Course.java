package com.example.studybuddy.betterdb;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "courses")
public class Course {

    @PrimaryKey(autoGenerate = true)
    public long id;
    @ColumnInfo(name = "name")
    public String name;

    public Course(String name){
        this.name = name;
    }
}
