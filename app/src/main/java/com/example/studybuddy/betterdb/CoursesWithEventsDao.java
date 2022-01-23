package com.example.studybuddy.betterdb;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface CoursesWithEventsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(CreatedEvent createdEvent);


    @Transaction
    @Query("SELECT * FROM courses")
    List<CoursesWithEvents> getAllCoursesWithEvents();

    @Transaction
    @Query("SELECT * FROM courses WHERE id= :id")
    List<CoursesWithEvents> getCoursesWithEventsFromId(long id);
}
