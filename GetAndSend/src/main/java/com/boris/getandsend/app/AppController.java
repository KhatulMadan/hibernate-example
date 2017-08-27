package com.boris.getandsend.app;

import com.boris.getandsend.config.AppConfig;
import com.boris.getandsend.entity.Task;
import com.boris.getandsend.service.CronManager;
import com.boris.getandsend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

/**
 * Created by boris on 01.08.17.
 */
@Controller
@Configuration
@ComponentScan("com.boris.getandsend.config")

public class AppController {

    @Autowired
    CronManager myCron = new CronManager();

    @Autowired
    private TaskService taskService;


    @RequestMapping("/task")
    public void requestTask(Model model, @RequestParam(value = "jsonString", required = false, defaultValue = "World") String jsonString) throws SQLException {
        model.addAttribute("jsonString", jsonString);
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        taskService = context.getBean(TaskService.class);
        jsonString = jsonString.replace("(","{");
        jsonString = jsonString.replace(")","}");
        taskService.add(new Task(jsonString));


    }

}


