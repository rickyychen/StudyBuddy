package com.example.studybuddy.betterdb;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface CoursesWithStudentsDao {
    // return list of obj. : all courses -> its students

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(EnrolledCourses enrolledcourses);


    @Transaction
    @Query("SELECT * FROM courses")
    List<CoursesWithStudents> getAllCoursesWithStudents();

    //@Transaction
    //@Query("SELECT * FROM students")
    //List<StudentsWithCourses> getAllStudentsWithCourses();

}
