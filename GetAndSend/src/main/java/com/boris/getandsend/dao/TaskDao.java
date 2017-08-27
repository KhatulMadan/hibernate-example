package com.boris.getandsend.dao;


import com.boris.getandsend.entity.Task;

import java.util.List;

/**
 * Created by boris on 17.08.17.
 */
public interface TaskDao {

    String getTask(int number);
    String getTaskDetails(int number);
    void update(int number);
    int getNumberOfTasks();
    void add(Task task);

}
