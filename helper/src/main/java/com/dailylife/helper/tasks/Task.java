package com.dailylife.helper.tasks;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class Task {

    private String id;
    private boolean isDone = false;
    @NotEmpty
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) &&
                Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                "isDone='" + isDone + '\''+
                ", description='" + description + '\'' +
                '}';
    }
}
