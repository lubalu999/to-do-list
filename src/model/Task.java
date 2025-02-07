package model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.util.Objects;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Task {
    private String taskName;
    private Priority priority;
    private boolean finished;

    public Task(String taskName, Priority priority, boolean finished) {
        this.taskName = taskName;
        this.priority = priority;
        this.finished = finished;
    }

    public Task(String taskName, int priorityIndex) throws Throwable {
        this.taskName = taskName;
        this.setPriorityIndex(priorityIndex);
        this.finished = false;
    }

    public Task() {}

    public void setPriorityIndex(int priorityIndex) {
        switch (priorityIndex) {
            case 1 -> this.priority = Priority.HIGH;
            case 2 -> this.priority = Priority.MEDIUM;
            case 3 -> this.priority = Priority.LOW;
            default -> throw new IllegalArgumentException("Wrong priority index, try again.");
        }
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getPriority() {
        return priority.getValue();
    }

    public boolean isFinished() {
        return finished;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Task task = (Task) obj;
        return finished == task.isFinished() && taskName.equalsIgnoreCase(task.getTaskName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskName.toLowerCase(), finished);
    }
}
