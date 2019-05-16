package bondalapati.avinash.roomdb;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

@Dao
public interface TaskDAO {

    @Query("Select * from Task")
    List<Task> getAllTasks();

    @Query("Select * from Task where Id = :ID")
    Task getTaskByID(int ID);

    @Insert(onConflict = IGNORE)
    void insertTask(Task task);


}
