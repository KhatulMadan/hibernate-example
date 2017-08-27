package com.boris.getandsend.service;
import com.boris.getandsend.tasks.TaskType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by boris on 01.08.17.
 */

@Component
public class CronManager {

@Autowired
private TaskService taskService;

@Autowired
private ApplicationContext appContext;


    @Scheduled(cron = "0 */5 * ? * *")
    public void cronTask() throws IOException, SQLException {

        int i = 1;

        while (i <= taskService.getNumberOfTasks())
        {
            TaskType task = TaskType.valueOf(taskService.getTask(i).toUpperCase());
            if (task != null) {
                System.out.println("got the task");
            }

            FileProcessAbstractService fileService = (FileProcessAbstractService) appContext.getBean(task.getProviderClass());


            fileService.executeTask(taskService.getTaskDetails(i));
            taskService.update(i);
            i++;

        }


        }
    }

