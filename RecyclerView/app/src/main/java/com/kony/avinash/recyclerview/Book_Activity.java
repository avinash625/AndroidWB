package com.kony.avinash.recyclerview;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Book_Activity extends AppCompatActivity {

    private TextView tvtitle, tvDescripion;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_);

        tvtitle = (TextView) findViewById(R.id.book_details_title_id);
        tvDescripion = (TextView) findViewById(R.id.book_details_category_id);
        img = (ImageView) findViewById(R.id.bookhumbnail);

        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String Description = intent.getExtras().getString("Description");
        int image = intent.getExtras().getInt("Thumbnail");


        tvtitle.setText(Title);
        tvDescripion.setText(Description);
        img.setImageResource(image);


    }
}
