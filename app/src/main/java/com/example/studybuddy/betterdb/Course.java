package com.example.studybuddy.betterdb;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "courses")
public class Course {

    @PrimaryKey
    public long id;
    @ColumnInfo(name = "name")
    public String name;

    public Course(long id, String name){
        this.id = id;
        this.name = name;
    }
}
