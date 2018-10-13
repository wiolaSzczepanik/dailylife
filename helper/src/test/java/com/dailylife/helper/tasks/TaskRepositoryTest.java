package com.dailylife.helper.tasks;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

class TaskRepositoryTest {


    @Test
    public void findAllTest(){

        TaskRepository taskRepository = new TaskRepository();
        Task task = new Task();

        taskRepository.save(task);
        Collection<Task> tasks = taskRepository.findAll();

        assertEquals(1, tasks.size());
        assertEquals(task,tasks.toArray()[0]);
    }

}