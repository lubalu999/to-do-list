public class Task {
    private String taskName;
    private String priority;
    private boolean isFinished;

    public Task(String taskName, int priorityIndex) throws Throwable {
        this.taskName = taskName;
        this.isFinished = false;
        this.setPriority(priorityIndex);
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
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
}
