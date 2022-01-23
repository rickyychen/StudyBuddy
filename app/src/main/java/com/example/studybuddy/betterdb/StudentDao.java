package com.example.studybuddy.betterdb;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentDao {

    @Query("SELECT * FROM students")
    List<Student> getAllStudents();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertStudent(Student student);

    @Delete
    void deleteStudent(Student student);


}
