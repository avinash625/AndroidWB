package com.kony.avinash.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Book> lstBook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstBook = new ArrayList<>();
        lstBook.add(new Book("One","Category Book One","Description", R.drawable.one));
        lstBook.add(new Book("two","Category Book two","Description", R.drawable.two));
        lstBook.add(new Book("three","Category Book three","Description", R.drawable.three));
        lstBook.add(new Book("four","Category Book four","Description", R.drawable.four));
        lstBook.add(new Book("five","Category Book five","Description", R.drawable.four));
        lstBook.add(new Book("six","Category Book six","Description", R.drawable.six));
        lstBook.add(new Book("One","Category Book One","Description", R.drawable.one));
        lstBook.add(new Book("two","Category Book two","Description", R.drawable.two));
        lstBook.add(new Book("three","Category Book three","Description", R.drawable.three));
        lstBook.add(new Book("four","Category Book four","Description", R.drawable.four));
        lstBook.add(new Book("five","Category Book five","Description", R.drawable.four));
        lstBook.add(new Book("six","Category Book six","Description", R.drawable.six));
        lstBook.add(new Book("One","Category Book One","Description", R.drawable.one));
        lstBook.add(new Book("two","Category Book two","Description", R.drawable.two));
        lstBook.add(new Book("three","Category Book three","Description", R.drawable.three));
        lstBook.add(new Book("four","Category Book four","Description", R.drawable.four));
        lstBook.add(new Book("five","Category Book five","Description", R.drawable.four));
        lstBook.add(new Book("six","Category Book six","Description", R.drawable.six));
        lstBook.add(new Book("One","Category Book One","Description", R.drawable.one));
        lstBook.add(new Book("two","Category Book two","Description", R.drawable.two));
        lstBook.add(new Book("three","Category Book three","Description", R.drawable.three));
        lstBook.add(new Book("four","Category Book four","Description", R.drawable.four));
        lstBook.add(new Book("five","Category Book five","Description", R.drawable.four));
        lstBook.add(new Book("six","Category Book six","Description", R.drawable.six));


        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lstBook);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);


    }
}
