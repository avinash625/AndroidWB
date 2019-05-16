package com.avinashbondalapatigmail.recyclerviewone;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

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

                //Toast.makeText(getApplicationContext(),taskNameValue,Toast.LENGTH_LONG).show();
                try{
                    SaveTask(taskNameValue, taskDescValue);
                }catch (FileNotFoundException f){
                    f.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }

            }

            private void SaveTask(String taskNameValue, String taskDescValue) throws FileNotFoundException, IOException {
                File file = new File(getFilesDir(),"testfile1.txt");
                FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                bufferedWriter.write(new String(taskNameValue+"$"+taskDescValue + "\n"));
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStreamWriter.close();
                fileOutputStream.close();
                finish();
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
