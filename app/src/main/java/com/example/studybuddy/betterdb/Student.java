package com.example.studybuddy.betterdb;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "students")
public class Student {


    @PrimaryKey(autoGenerate = true)
    public long studentId;
    @ColumnInfo(name = "studentfirstname")
    public String StudentFirstName;
    @ColumnInfo(name = "studentlastname")
    public String StudentLastName;

    public Student(String StudentFirstName, String StudentLastName){
        this.StudentFirstName = StudentFirstName;
        this.StudentLastName = StudentLastName;
    }

}


