package com.example.myapplication_rc_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

import com.example.myapplication_rc_final.Adapter.Rc1_Adapter;
import com.example.myapplication_rc_final.Modal.Student;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Student> studentArrayList;
    private ArrayList<String> iname;
    private RecyclerView lstStudentData;
    private Rc1_Adapter mAdapter;
  //  private List<Student> iname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        processJSON();
    lstStudentData=findViewById(R.id.rc1);



        mAdapter = new Rc1_Adapter(studentArrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
       lstStudentData.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL, 16));
        lstStudentData.setHasFixedSize(false);
       lstStudentData.setLayoutManager(mLayoutManager);
       lstStudentData.setItemAnimator(new DefaultItemAnimator());
     lstStudentData.setAdapter(mAdapter);

        mAdapter.notifyDataSetChanged();


    }


    public String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = getAssets().open("studentdetails.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private void processJSON() {
        String js = loadJSONFromAsset();
        if (js != null) {
            // Log.d("json",js);
            try {
                JSONArray mJSONArray = new JSONArray(js);
                studentArrayList = new ArrayList<>();
                for (int i = 0; i < mJSONArray.length(); i++) {

                    JSONObject mJSONObj = mJSONArray.getJSONObject(i);
                    //  Log.d("mjson", mJSONObj.toString());
                    if (mJSONObj.has("sid")) {
                        String id = mJSONObj.getString("sid");
                        String sname = mJSONObj.getString("sname");
                        String gender = mJSONObj.getString("gender");
                           Log.d("mjson_ID", String.valueOf(id));
                           Log.d("mjson_name", String.valueOf(sname));
                           Log.d("mjson_gender", String.valueOf(gender));
                        studentArrayList.add(new Student(String.valueOf(id), String.valueOf(sname), String.valueOf(gender)));

                        //  for (Student str : studentArrayList) {
                        //      System.out.println(str.getSid());
                        //  System.out.println(str.getSname());

                        // }
                        System.out.println("Using Iterator class");
                        System.out.println("-----------------------");
                        Iterator<Student> it = studentArrayList.iterator();
                        while (it.hasNext()) {
                            System.out.println(it.next().getSname());
                        }
                    }


                }
                // s.setStudentArrayList(studentArrayList);
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }
}
