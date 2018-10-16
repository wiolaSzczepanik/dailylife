package com.dailylife.helper.tasks;

import org.springframework.stereotype.Repository;

import java.util.*;

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

    public void delete(String id) {
        tasks.remove(id);
    }


    public void mark(String id) {
        tasks.get(id).setDone(true);
        }

}
