import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while (true) {
            printMessage();

            if (scanner.hasNextInt()) {
                int action = scanner.nextInt();

                switch (action) {
                    case 1 -> {
                        System.out.println("Enter task name - ");
                        String name = scanner.next();

                        System.out.println("Enter task priority (1 - High, 2 - Medium, 3 - Low) - ");
                        int priority = scanner.nextInt();

                        Task newTask = new Task(name, priority);
                        manager.addTask(newTask);
                    }
                    case 2 -> {
                        manager.printAllTasks();
                    }
                    case 3 -> {
                        System.out.print("Enter task name or task number - ");

                        if (scanner.hasNextInt()) {
                            int index = scanner.nextInt();
                            manager.removeTask(index);
                        } else {
                            String name = scanner.nextLine();
                            manager.removeTask(name);
                        }
                    }
                    case 4 -> {
                        System.out.print("Enter task name or task number - ");

                        if (scanner.hasNextInt()) {
                            int index = scanner.nextInt();
                            manager.makeFinished(index);
                        } else {
                            String name = scanner.nextLine();
                            manager.makeFinished(name);
                        }
                    }
                    case 5 -> {
                        System.out.println("Exit...");
                        break;
                    }
                    default -> {
                        System.out.println("Incorrect option number. Try again");
                    }
                }
            }
        }
    }

    public static void printMessage() {
        System.out.print("\n=== Task Manager ===\n" +
                "1. Add task\n" +
                "2. Show tasks\n" +
                "3. Delete task\n" +
                "4. Mark task as completed\n" +
                "5. Exit\n\n" +
                "Choose the option: ");
    }
}