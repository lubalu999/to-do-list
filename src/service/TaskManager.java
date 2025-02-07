package service;

import model.Task;

import java.util.ArrayList;

public class TaskManager {
    private final ArrayList<Task> taskList = new ArrayList<>();

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(ArrayList<Task> list) {
        taskList.addAll(list);
    }

    public void addTask(Task task) {
        if (taskList.contains(task)) {
            System.out.println("You already have a task \"" + task.getTaskName() + "\".");
        } else {
            taskList.add(task);
            System.out.println("Task \"" + task.getTaskName() + "\" successfully added.");
        }
    }

    public void removeTask(String taskName) {
        if (taskList.isEmpty()) {
            System.out.println("You do not have any task yet.");
            return;
        }

        boolean isRemoved = taskList.removeIf(task -> taskName.equalsIgnoreCase(task.getTaskName()));

        if (isRemoved) {
            System.out.println("Task \"" + taskName + "\" successfully removed.");
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
                task.setFinished(true);
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
            task.setFinished(true);

            System.out.println("Task \"" + task.getTaskName() + "\" successfully completed.");
        } else {
            System.out.println("Invalid index. Use the index from task list.");
        }
    }

    public void printAllTasks() {
        if (taskList.isEmpty()) {
            System.out.println("The task list is empty! Fill it with your tasks.");
            return;
        }

        System.out.println("-- List of all tasks --");

        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            String checkbox = task.isFinished() ? "[x] " : "[ ] ";

            System.out.println(checkbox + (i + 1) + ". " + task.getTaskName() + " (" + task.getPriority() + ")");
        }
    }
}
