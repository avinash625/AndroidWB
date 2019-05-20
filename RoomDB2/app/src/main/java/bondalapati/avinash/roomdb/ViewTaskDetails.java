package bondalapati.avinash.roomdb;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProviders;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class ViewTaskDetails extends AppCompatActivity {

    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        TextView taskName = (TextView) findViewById(R.id.viewTaskNameValue);
        TextView taskDesc = (TextView) findViewById(R.id.viewTaskDescValue);

        Intent intent = getIntent();
        taskName.setText(intent.getExtras().getString("taskName"));
        taskDesc.setText(intent.getExtras().getString("taskDesc"));
        id = intent.getExtras().getInt("id");

        findViewById(R.id.editTaskButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                TaskViewModel viewModel = ViewModelProviders.of(ViewTaskDetails.this).get(TaskViewModel.class);
                Task task = new Task(((TextView) findViewById(R.id.viewTaskNameValue)).getText().toString(),((TextView) findViewById(R.id.viewTaskDescValue)).getText().toString());
                task.setTaskName(task.getTaskName());
                task.setId(id);
                Intent intent = new Intent(v.getContext(),EditTaskDetails.class);
                intent.putExtra("taskName",task.getTaskName());
                intent.putExtra("taskDesc",task.getTaskDesc());
                intent.putExtra("id",task.getId());
                startActivity(intent);
                finish();

            }
        });

        findViewById(R.id.deleteTaskButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                TaskViewModel viewModel = ViewModelProviders.of(ViewTaskDetails.this).get(TaskViewModel.class);
                Task task = new Task(((TextView) findViewById(R.id.viewTaskNameValue)).getText().toString(),((TextView) findViewById(R.id.viewTaskDescValue)).getText().toString());
                task.setId(id);
                viewModel.deleteTask(task);
                finish();
            }
        });
    }
}
