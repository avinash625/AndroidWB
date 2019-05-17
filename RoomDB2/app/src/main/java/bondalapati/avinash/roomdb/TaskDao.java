package bondalapati.avinash.roomdb;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TaskDao {

    @Insert
    void insertTask(Task task);

    @Delete
    void deleteTask(Task task);

    @Query("SELECT * from task")
    LiveData<List<Task>> getAllTasks();

    @Query("SELECT * from task WHERE id = :id")
    Task getTask(int id);

    @Query("DELETE FROM task")
    void deleteAllTasks();

}
