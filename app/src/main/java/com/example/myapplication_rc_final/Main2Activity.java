package com.example.myapplication_rc_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication_rc_final.Modal.Student;

public class Main2Activity extends AppCompatActivity {
private TextView a1,a2,a3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        a1=findViewById(R.id.a1);
        a2=findViewById(R.id.a2);
        a3=findViewById(R.id.a3);
        Intent i=getIntent();
        Student studobj = (Student) i.getExtras().getSerializable("stud");
        a1.setText("Student ID::"+studobj.getSid());
        a2.setText("Student ID::"+studobj.getSname());
        a3.setText("Student ID::"+studobj.getGender());
    }
}
