package bondalapati.avinash.roomdb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class EditTaskDetails extends AppCompatActivity {

    Task task;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_edit_task_details);
        setTitle(R.string.editTaskValue);

        task = new Task();
        Intent intent = getIntent();
        task.setTaskName(intent.getExtras().getString("taskName"));
        task.setTaskDesc(intent.getExtras().getString("taskDesc"));
        task.setId(intent.getExtras().getInt("id"));

        TextView taskName = (TextView) findViewById(R.id.editTaskNameValue);
        TextView taskDesc = (TextView) findViewById(R.id.editTaskDescValue);

        taskName.setText(task.getTaskName());
        taskDesc.setText(task.getTaskDesc());

        Button saveButton = (Button) findViewById(R.id.editTask);
        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                TaskViewModel viewModel = ViewModelProviders.of(EditTaskDetails.this).get(TaskViewModel.class);
                task.setTaskName(((TextView) findViewById(R.id.editTaskNameValue)).getText().toString());
                task.setTaskDesc(((TextView) findViewById(R.id.editTaskDescValue)).getText().toString());
                viewModel.updateTask(task);
                finish();
            }
        });
    }
}
