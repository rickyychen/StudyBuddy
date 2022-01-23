package com.example.studybuddy.betterdb;


import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Query;
import androidx.room.Relation;

import java.util.List;

public class CoursesWithStudents {

    @Embedded
    public Course course; //c

    @Relation(
            parentColumn = "id", //f
            entityColumn = "studentId", //f
            entity = Student.class, //c
            associateBy = @Junction(EnrolledCourses.class)

    )
    public List<Student> EnrolledStudents;



}
