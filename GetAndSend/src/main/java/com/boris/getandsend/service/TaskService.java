package com.boris.getandsend.service;

import com.boris.getandsend.entity.Task;

/**
 * Created by boris on 17.08.17.
 */
public interface TaskService {

    String getTask(int number);
    String getTaskDetails(int number);
    void update(int number);
    int getNumberOfTasks();
    void add(Task task);



}
