package bondalapati.avinash.roomdb;

import android.annotation.SuppressLint;
import android.arch.persistence.room.RoomDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.widget.Button;
import android.widget.TextView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class enterTaskDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_enter_task_details);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Button saveTask = (Button) findViewById(R.id.save_task);
        saveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView taskName = (TextView) findViewById(R.id.taskName);
                String taskNameValue = taskName.getText().toString();
                AppDatabase instance = AppDatabase.getInMemoryDatabase(getApplicationContext());
                instance.TaskModel().insertTask(new Task(taskNameValue));
                finish();
            }
        });

    }
}
