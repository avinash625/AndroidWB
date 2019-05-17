package bondalapati.avinash.roomdb;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class enterTaskDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_task_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button saveTaskButton = (Button) findViewById(R.id.buttonSaveTask);
        saveTaskButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                TextView taskName = (TextView) findViewById(R.id.enterTaskNameValue);
                TextView taskDesc = (TextView) findViewById(R.id.enterTaskDescValue);
                TaskViewModel taskViewModel = ViewModelProviders.of(enterTaskDetails.this).get(TaskViewModel.class);
                taskViewModel.insertTask(new Task(taskName.getText().toString(),taskDesc.getText().toString()));
                finish();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
