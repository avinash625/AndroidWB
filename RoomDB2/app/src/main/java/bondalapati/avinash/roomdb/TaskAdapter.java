package bondalapati.avinash.roomdb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskHolder> {

    private final LayoutInflater layoutInflater;
    List<Task> allTasks;

    TaskAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.task_item,parent, false);
        return new TaskHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskHolder holder, int position) {
        if(allTasks != null){
            Task current = allTasks.get(position);
            holder.taskName.setText(allTasks.get(position).getTaskName());
            holder.taskDesc.setText(allTasks.get(position).getTaskDesc());
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

        public TaskHolder(@NonNull View itemView) {
            super(itemView);

            taskName = itemView.findViewById(R.id.taskDescValue);
            taskDesc = itemView.findViewById(R.id.taskNameValue);
        }


    }
}
