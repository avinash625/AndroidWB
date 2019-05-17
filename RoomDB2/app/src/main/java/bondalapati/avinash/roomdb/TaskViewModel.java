package bondalapati.avinash.roomdb;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {
    public TaskViewModel(@NonNull Application application) {
        super(application);
        taskRepository = new TaskRepository(application);
        allTasks = taskRepository.getAllWords();
    }

    private TaskRepository taskRepository;

    private LiveData<List<Task>> allTasks;

    LiveData<List<Task>> getAllTasks(){return allTasks;}

    public void insertTask(Task task){taskRepository.insertTask(task);}
}
