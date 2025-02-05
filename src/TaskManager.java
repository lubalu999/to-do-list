import java.util.ArrayList;

public class TaskManager {
    private final ArrayList<Task> taskList = new ArrayList<>();

    public void addTask(Task task) {
        for (Task taskInList : taskList) {
            String oldName = taskInList.getTaskName();
            String newName = task.getTaskName();
            if (newName.equalsIgnoreCase(oldName)) {
                System.out.println("You already have a task \"" + oldName + "\".");
                return;
            }
        }

        taskList.add(task);
        System.out.println("Task \"" + task.getTaskName() + "\" successfully added.");
    }

    public void removeTask(String taskName) {
        if (taskList.isEmpty()) {
            System.out.println("You do not have any task yet.");
            return;
        }

        boolean isRemoved = taskList.removeIf(task -> taskName.equalsIgnoreCase(task.getTaskName()));

        if (isRemoved) {
            System.out.println("Task " + taskName + " successfully removed.");
        } else {
            System.out.println("Task not found. Try again.");
        }
    }

    public void removeTask(int taskIndex) {
        if (taskList.isEmpty()) {
            System.out.println("You do not have any task yet.");
            return;
        }

        if (taskIndex <= taskList.size() && taskIndex >= 1) {
            String taskName = taskList.get(taskIndex - 1).getTaskName();
            taskList.remove(taskIndex - 1);

            System.out.println("Task \"" + taskName + "\" successfully removed.");
        } else {
            System.out.println("Invalid index. Use the index from task list.");
        }
    }

    public void makeFinished(String taskName) {
        for (Task task : taskList) {
            if (taskName.equalsIgnoreCase(task.getTaskName())) {
                task.setFinished();
                System.out.println("Task \"" + task.getTaskName() + "\" successfully completed.");
                return;
            }
        }

        System.out.println("You do not have \"" + taskName + "\" task.");
    }

    public void makeFinished(int taskIndex) {
        if (taskList.isEmpty()) {
            System.out.println("You do not have any task yet.");
        } else if (taskIndex <= taskList.size() && taskIndex >= 1) {
            Task task = taskList.get(taskIndex - 1);
            task.setFinished();

            System.out.println("Task \"" + task.getTaskName() + "\" successfully completed.");
        } else {
            System.out.println("Invalid index. Use the index from task list.");
        }
    }

    public void printAllTasks() {
        System.out.println("-- List of all tasks --");

        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            String checkbox = task.isFinished() ? "[x] " : "[ ] ";

            System.out.println(checkbox + (i + 1) + ". " + task.getTaskName() + " (" + task.getPriority() + ")");
        }
    }
}
