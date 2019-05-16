package com.avinashbondalapatigmail.recyclerviewone;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();

        RecyclerView myRecyclerView = (RecyclerView) findViewById(R.id.task_recycler_view_id);
        TaskAdapter taskAdapter = new TaskAdapter(this,readFileValue());

        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerView.setAdapter(taskAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ceatetask);

        FloatingActionButton myFAB = (FloatingActionButton) findViewById(R.id.myFAB);
        myFAB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, EnterTaskDetails.class);
                startActivity(myIntent);
            }

        });


    }

    private List<Task> readFileValue() {
        List<Task> myTasks = new ArrayList<Task>();
        try{

            Context context = getApplicationContext();
            FileInputStream fileInputStream = context.openFileInput("testfile1.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String lineData = bufferedReader.readLine();
            while(lineData != null){

                myTasks.add(new Task(lineData.split("\\$")[0],lineData.split("\\$")[1]));
                lineData = bufferedReader.readLine();
            }
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();

        }catch (FileNotFoundException f){
            f.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return myTasks;
    }
}
