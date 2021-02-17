package com.dailylife.helper.tasks;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private static final Logger log = org.apache.logging.log4j.LogManager.getLogger(TaskController.class);

    private TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    Collection<Task> tasks() {
        return taskRepository.findAll();
    }

    @PostMapping("/")
    ResponseEntity<Task> createTask(@Valid @RequestBody Task task) throws URISyntaxException {

        log.info("Request to create group: {}", task);
        Task result = taskRepository.save(task);

        return ResponseEntity
                .created(new URI("/api/tasks/" + result.getId()))
                .body(result);
    }

    @DeleteMapping("/{id}")
    void deleteTask(@PathVariable String id){

        log.info("Request to delete task by id: {}", id);
        taskRepository.delete(id);
    }

    @PutMapping("/{id}")
    void markTask(@PathVariable String id){

        log.info("Request to mark task by id: {}", id);
        taskRepository.mark(id);
    }
}
