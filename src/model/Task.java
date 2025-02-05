package model;

import java.util.Objects;

public class Task {
    private String taskName;
    private String priority;
    private boolean isFinished;

    public Task(String taskName, int priorityIndex) throws Throwable {
        this.taskName = taskName;
        this.isFinished = false;
        this.setPriority(priorityIndex);
    }

    public void setPriority(int priorityIndex) {
        switch (priorityIndex) {
            case 1 -> this.priority = "High";
            case 2 -> this.priority = "Medium";
            case 3 -> this.priority = "Low";
            default -> throw new IllegalArgumentException("Wrong priority index, try again.");
        }
    }

    public void setFinished() {
        isFinished = true;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getPriority() {
        return priority;
    }

    public boolean isFinished() {
        return isFinished;
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
        return isFinished == task.isFinished() && taskName.equalsIgnoreCase(task.getTaskName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskName.toLowerCase(), isFinished);
    }
}
