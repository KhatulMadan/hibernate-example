package com.boris.getandsend.service;

import com.boris.getandsend.dao.TaskDao;
import com.boris.getandsend.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created by boris on 17.08.17.
 */
@Service
@Transactional
public class TaskServiceImp implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Override
    public String getTask(int number){
        return taskDao.getTask(number);
    }

    @Override
    public String getTaskDetails(int number){
        return taskDao.getTaskDetails(number);
    }

    @Override
    public void update(int number){
        taskDao.update(number);
    }

    @Override
    public int getNumberOfTasks(){
        return taskDao.getNumberOfTasks();
    }

    @Override
    public void add(Task task){
        taskDao.add(task);
    }
}
