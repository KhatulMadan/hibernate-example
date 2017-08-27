package com.boris.getandsend.service;
import org.springframework.context.ApplicationContext;


import com.boris.getandsend.tasks.TaskType;

import java.io.IOException;

import static com.sun.tools.javadoc.Main.execute;

/**
 * Created by boris on 09.08.17.
 */
public abstract class FileProcessAbstractService {

    public abstract void executeTask(String jsonString) throws IOException;

}
