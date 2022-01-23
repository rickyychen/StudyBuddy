package com.example.studybuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.UiThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.room.Room;

import com.example.studybuddy.betterdb.Course;
import com.example.studybuddy.betterdb.CourseDao;
import com.example.studybuddy.betterdb.CoursesWithStudents;
import com.example.studybuddy.betterdb.CoursesWithStudentsDao;
import com.example.studybuddy.betterdb.EnrolledCourses;
import com.example.studybuddy.betterdb.EventDao;
import com.example.studybuddy.betterdb.Student;
import com.example.studybuddy.betterdb.StudentDao;
import com.example.studybuddy.databinding.ActivityMainBinding;
import com.example.studybuddy.ui.home.find_session;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);


        Course course1 = new Course(1000, "comp202");

        Student student1 = new Student(1, "John", "Doe");

        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {

                // SETTING UP ALL THE DAOS
                Database dbtool = Room.databaseBuilder(getApplicationContext(), Database.class, "StudyBuddy").build();
                CourseDao coursedao = dbtool.getCourseDao();
                StudentDao studentdao = dbtool.getStudentDao();
                EventDao eventDao = dbtool.getEventDao();


                CoursesWithStudentsDao courseswithstudentsdao = dbtool.getCoursesWithStudentsDao();
                coursedao.insertCourse(course1);
                studentdao.insertStudent(student1);
                final List<Course> courses = coursedao.getAllCourses();
                final List<Student> students = studentdao.getAllStudents();
                Course comp2 = courses.get(0);
                Student stud1 = students.get(0);
                EnrolledCourses enrolled = new EnrolledCourses();
                enrolled.id = comp2.id;
                enrolled.studentId = stud1.studentId;
                courseswithstudentsdao.insert(enrolled);
                List<CoursesWithStudents> list = courseswithstudentsdao.getAllCoursesWithStudents();
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        updateUi(courses);
                    }
                });
            }
        });

        /*
        host = findViewById(R.id.button2);
        host.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, session.class);
                startActivity(intent);
            }
        });*/
    }

    @UiThread
    public void updateUi(List<Course> courses){

    }

    public void course_select(View v){
        Intent i = new Intent(MainActivity.this, find_session.class);
        String course = ((Button)v).getText().toString();
        i.putExtra("COURSE", course);
        startActivity(i);
    }

}

