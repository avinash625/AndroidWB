package com.avinashbondalapatigmail.recyclerviewone;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ceatetask);

        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("avinashone",20));
        personList.add(new Person("avinashtwo",21));
        personList.add(new Person("avinashone",20));
        personList.add(new Person("avinashtwo",21));personList.add(new Person("avinashone",20));
        personList.add(new Person("avinashtwo",21));personList.add(new Person("avinashone",20));
        personList.add(new Person("avinashtwo",21));personList.add(new Person("avinashone",20));
        personList.add(new Person("avinashtwo",21));personList.add(new Person("avinashone",20));
        personList.add(new Person("avinashtwo",21));personList.add(new Person("avinashone",20));
        personList.add(new Person("avinashtwo",21));personList.add(new Person("avinashone",20));
        personList.add(new Person("avinashtwo",21));personList.add(new Person("avinashone",20));
        personList.add(new Person("avinashtwo",21));
        personList.add(new Person("avinashone",20));
        personList.add(new Person("avinashtwo",21));
        personList.add(new Person("avinashone",20));
        personList.add(new Person("avinashtwo",21));
        personList.add(new Person("avinashone",20));
        personList.add(new Person("avinashtwo",21));personList.add(new Person("avinashone",20));
        personList.add(new Person("avinashtwo",21));personList.add(new Person("avinashone",20));
        personList.add(new Person("avinashtwo",21));personList.add(new Person("avinashone",20));
        personList.add(new Person("avinashtwo",21));personList.add(new Person("avinashone",20));
        personList.add(new Person("avinashtwo",21));personList.add(new Person("avinashone",20));
        personList.add(new Person("avinashtwo",21));personList.add(new Person("avinashone",20));
        personList.add(new Person("avinashtwo",21));personList.add(new Person("avinashone",20));
        personList.add(new Person("avinashtwo",21));
        personList.add(new Person("avinashone",20));
        personList.add(new Person("avinashtwo",21));










        //for recycler view
//        RecyclerView myRecyclerView = (RecyclerView) findViewById(R.id.recyclerView_Id);
//        PersonAdapter myPersonAdapter = new PersonAdapter(this,personList);
//
//        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        myRecyclerView.setAdapter(myPersonAdapter);



        //for floating button.
        FloatingActionButton myFAB = (FloatingActionButton) findViewById(R.id.myFAB);
        myFAB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"You clicked on the event",Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(MainActivity.this, EnterTaskDetails.class);
                startActivity(myIntent);
            }

        });

    }
}
