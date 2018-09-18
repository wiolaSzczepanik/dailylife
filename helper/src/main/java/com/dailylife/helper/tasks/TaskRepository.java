package com.dailylife.helper.tasks;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Repository
public class TaskRepository {

    private Map<String, Task> tasks = new HashMap<>();

    public Collection<Task> findAll() {
        return tasks.values();
    }

    public Task save(Task task) {
        String taskId = generateId();
        task.setId(taskId);
        tasks.put(taskId, task);
        return task;
    }

    private String generateId() {
        Random random = new Random();
        return String.valueOf(random.nextInt());
    }
}
