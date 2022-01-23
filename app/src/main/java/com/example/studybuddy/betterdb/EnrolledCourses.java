package com.example.studybuddy.betterdb;

import androidx.room.Entity;

@Entity(primaryKeys = {"id", "studentId"})
public class EnrolledCourses {

    public long id;
    public long studentId;




}
