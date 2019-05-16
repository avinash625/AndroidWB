package bondalapati.avinash.roomdb;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Task {
    @PrimaryKey
    @NonNull
    int id;

    public Task(String TaskName){
        this.TaskName = TaskName;
    }
    @ColumnInfo(name = "taskname")
    String TaskName;

    @ColumnInfo(name = "taskdesc")
    String TaskDesc;

    @ColumnInfo(name = "tasktags")
    String TaskTags;

    public String getTaskName() {
        return TaskName;
    }

    public void setTaskName(String taskName) {
        TaskName = taskName;
    }

    public String getTaskDesc() {
        return TaskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        TaskDesc = taskDesc;
    }

    public String getTaskTags() {
        return TaskTags;
    }

    public void setTaskTags(String taskTags) {
        TaskTags = taskTags;
    }

}
