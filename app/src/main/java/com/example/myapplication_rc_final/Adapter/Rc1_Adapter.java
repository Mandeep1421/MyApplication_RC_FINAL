package com.example.myapplication_rc_final.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication_rc_final.Main2Activity;
import com.example.myapplication_rc_final.Modal.Student;
import com.example.myapplication_rc_final.R;


import java.util.List;

public class Rc1_Adapter extends  RecyclerView.Adapter<Rc1_Adapter.Myviewholder>{

    private List<Student> StudentList;
private Context mcontext;
    public Rc1_Adapter(List<Student> studentList) {
        StudentList = studentList;
    }

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.rc_list, viewGroup, false);
        mcontext = viewGroup.getContext();
        return new Myviewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder myviewholder, int i) {
       final Student stud = StudentList.get(i);
      //  myviewholder.sid.setText("Student ID::"+stud.getSid());
        myviewholder.sname.setText("Student Name::"+stud.getSname());
      //  myviewholder.gender.setText("Gender::"+stud.getGender());
        myviewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          //  Toast.makeText(mcontext, "hello",Toast.LENGTH_LONG).show();
                Intent i=new Intent(mcontext, Main2Activity.class);
                i.putExtra("stud",stud);
                mcontext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return StudentList.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder
    {
            public TextView sid,sname,gender;

        public Myviewholder(  View itemView) {
            super(itemView);

            sname=(TextView) itemView.findViewById(R.id.lsname);


        }
    }

}
