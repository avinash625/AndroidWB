package com.avinashbondalapatigmail.recyclerviewone;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class EnterTaskDetails extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_enter_task_details);

        Button  saveTask = (Button) findViewById(R.id.save_task);
        saveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView taskName = (TextView) findViewById(R.id.task_name);
                String taskNameValue = (String) taskName.getText().toString();

                TextView taskDesc = (TextView) findViewById(R.id.task_desc);
                String taskDescValue = (String) taskDesc.getText().toString();

                Toast.makeText(getApplicationContext(),taskNameValue,Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }

    private void toggle() {

    }

    private void hide() {

    }

    @SuppressLint("InlinedApi")
    private void show() {

    }

    /**
     * Schedules a call to hide() in delay milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {

    }
}
