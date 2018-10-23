package com.dailylife.helper.tasks;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import static org.junit.jupiter.api.Assertions.*;

class TaskRepositoryTest {

    @Test
    public void testRepositoryWithOneElement(){
        TaskRepository taskRepository = new TaskRepository();
        Task task = new Task();

        taskRepository.save(task);
        Collection<Task> tasks = taskRepository.findAll();

        assertEquals(1, tasks.size());
        assertEquals(task,tasks.toArray()[0]);
    }

    @Test
    public void testEmptyRepository(){
        TaskRepository taskRepository = new TaskRepository();
        Collection<Task> tasks = taskRepository.findAll();
        assertEquals(0,tasks.size());
    }

    @Test
    public void testRepositoryWithCoupleElements(){
        Task task = new Task();
        Task task1 = new Task();
        Task task2 = new Task();
        Task task3 = new Task();

        TaskRepository taskRepository = new TaskRepository();

        taskRepository.save(task);
        taskRepository.save(task1);
        taskRepository.save(task2);
        taskRepository.save(task3);

        Collection<Task> tasks = taskRepository.findAll();

        assertEquals(4, tasks.size());
    }

}