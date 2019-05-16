package com.avinashbondalapatigmail.recyclerviewone;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskHolder> {

    private Context context;
    private List<Task> taskList;

    public TaskAdapter(Context context, List<Task> taskList) {
        this.context = context;
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public TaskHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.itemlayout,viewGroup, false);

        return new TaskHolder((view));

    }

    @Override
    public void onBindViewHolder(@NonNull final TaskHolder taskHolder, int i) {
        taskHolder.taskName.setText(taskList.get(i).getTaskName());
        taskHolder.taskDesc.setText(taskList.get(i).getTaskDesc());

        taskHolder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),taskHolder.taskName.getText(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public class TaskHolder extends RecyclerView.ViewHolder{

        TextView taskName;
        TextView taskDesc;
        CheckBox taskcheck;


        public TaskHolder(@NonNull View itemView) {
            super(itemView);

            taskName = (TextView) itemView.findViewById(R.id.task_id);
            taskDesc = (TextView) itemView.findViewById(R.id.task_desc_value);
            taskcheck = (CheckBox) itemView.findViewById(R.id.task_checkbox);
        }
    }
}
