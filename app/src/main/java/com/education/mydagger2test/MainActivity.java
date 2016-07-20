package com.education.mydagger2test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

import dagger.Lazy;

public class MainActivity extends AppCompatActivity {
    private ActivityComponent activityComponent;
    @Inject
    Student student;
    @Inject
    Student zhangsan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityComponent = DaggerActivityComponent.builder().studentModule(new StudentModule()).build();
        activityComponent.inject(this);
        Lazy<Student> studentLazy = activityComponent.lazyStudent();

        Log.d("------", zhangsan + "------" + student);
    }
}
