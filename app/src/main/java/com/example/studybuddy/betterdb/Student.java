package com.example.studybuddy.betterdb;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "students")
public class Student {


    @PrimaryKey()
    public long studentId;
    @ColumnInfo(name = "studentfirstname")
    public String StudentFirstName;
    @ColumnInfo(name = "studentlastname")
    public String StudentLastName;

}


