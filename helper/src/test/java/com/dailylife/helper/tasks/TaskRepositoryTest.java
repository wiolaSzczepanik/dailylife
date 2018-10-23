package com.dailylife.helper.tasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import static org.junit.jupiter.api.Assertions.*;

class TaskRepositoryTest {

    TaskRepository taskRepository;

    @BeforeEach
    public void init(){
        taskRepository = new TaskRepository();
    }

    @Test
    public void testRepositoryWithOneElement(){
        Task task = new Task();

        taskRepository.save(task);
        Collection<Task> tasks = taskRepository.findAll();

        assertEquals(1, tasks.size());
        assertEquals(task,tasks.toArray()[0]);
    }

    @Test
    public void testEmptyRepository(){
        Collection<Task> tasks = taskRepository.findAll();
        assertEquals(0,tasks.size());
    }

    @Test
    public void testRepositoryWithCoupleElements(){
        Task task = new Task();
        Task task1 = new Task();
        Task task2 = new Task();
        Task task3 = new Task();

        taskRepository.save(task);
        taskRepository.save(task1);
        taskRepository.save(task2);
        taskRepository.save(task3);

        Collection<Task> tasks = taskRepository.findAll();

        assertEquals(4, tasks.size());
    }

}