package bondalapati.avinash.roomdb;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TaskRepository {

    private TaskDao taskDao;
    private LiveData<List<Task>> allTasks;

    TaskRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        taskDao = db.TaskDao();
        allTasks = taskDao.getAllTasks();
    }

    public void insertTask(Task task) {
        new insertTaskAsync(taskDao).execute(task);
    }

    public void deleteTask(Task task){
        new deleteTaskAsync(taskDao).execute(task);
    }

    public void updateTask(Task task){ new updateTaskAsync(taskDao).execute(task);}

    public LiveData<List<Task>> getAllWords(){
        return taskDao.getAllTasks();
    }

    private class insertTaskAsync extends AsyncTask<Task,Void,Void>{

        private TaskDao taskDao;
        insertTaskAsync(TaskDao taskdao){
            this.taskDao = taskdao;
        }

        @Override
        protected Void doInBackground(Task... tasks) {
            taskDao.insertTask(tasks[0]);
            return null;
        }
    }

    private class updateTaskAsync extends AsyncTask<Task, Void, Void>{

        private TaskDao taskDao;

        updateTaskAsync(TaskDao taskDao){
            this.taskDao = taskDao;
        }
        @Override
        protected Void doInBackground(Task... tasks) {
            taskDao.updateTask(tasks[0]);
            return null;
        }
    }

    private class deleteTaskAsync extends AsyncTask<Task, Void, Void>{

        private TaskDao taskDao;

        deleteTaskAsync(TaskDao taskDao){
            this.taskDao = taskDao;
        }

        @Override
        protected Void doInBackground(Task... tasks) {
            taskDao.deleteTask(tasks[0]);
            return null;
        }
    }
}
