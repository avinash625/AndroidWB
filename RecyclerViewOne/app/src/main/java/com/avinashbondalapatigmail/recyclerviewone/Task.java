package com.avinashbondalapatigmail.recyclerviewone;

import java.io.Serializable;

public class Task implements Serializable {
    String taskName;
    String taskDesc;

    Task(String taskName, String taskDesc){
        this.taskName = taskName;
        this.taskDesc = taskDesc;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

}
