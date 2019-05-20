package bondalapati.avinash.roomdb;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskHolder> {

    private final LayoutInflater layoutInflater;
    private Context context;
    List<Task> allTasks;

    TaskAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.task_item,parent, false);
        return new TaskHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final TaskHolder holder, final int position) {
        if(allTasks != null){
            holder.taskName.setText(allTasks.get(position).getTaskName());
            holder.taskDesc.setText(allTasks.get(position).getTaskDesc());
            holder.itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),allTasks.get(position).getTaskName(),Toast.LENGTH_LONG).show();
                    Intent intent   = new Intent(context, ViewTaskDetails.class);
                    intent.putExtra("taskName",allTasks.get(position).getTaskName());
                    intent .putExtra("taskDesc",allTasks.get(position).getTaskDesc());
                    intent.putExtra("id",allTasks.get(position).getId());
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if(allTasks != null)
            return allTasks.size();
        return 0;
    }

    public void setTasks(List<Task> tasks) {
        allTasks = tasks;
        notifyDataSetChanged();
    }

    public class TaskHolder extends RecyclerView.ViewHolder{

        TextView taskName;
        TextView taskDesc;
        int id;

        public TaskHolder(@NonNull View itemView) {
            super(itemView);

            taskName = itemView.findViewById(R.id.taskNameValue);
            taskDesc = itemView.findViewById(R.id.taskDescValue);
        }


    }
}
