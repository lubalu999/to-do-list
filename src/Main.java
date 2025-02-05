import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        boolean exit = false;

        while (!exit) {
            printMessage();

            if (scanner.hasNextInt()) {
                int action = scanner.nextInt();
                scanner.nextLine();

                switch (action) {
                    case 1 -> {
                        System.out.print("Enter task name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter task priority (1 - High, 2 - Medium, 3 - Low): ");
                        if (scanner.hasNextInt()) {
                            int priority = scanner.nextInt();
                            scanner.nextLine();

                            try {
                                Task newTask = new Task(name, priority);
                                manager.addTask(newTask);
                            } catch (IllegalArgumentException exception) {
                                System.out.println(exception.getMessage());
                            }
                        } else {
                            System.out.println("Please, choose the priority from 1 (High) to 3 (Low).");
                        }
                    }
                    case 2 -> {
                        manager.printAllTasks();
                    }
                    case 3 -> {
                        System.out.print("Enter task name or task number: ");

                        if (scanner.hasNextInt()) {
                            int index = scanner.nextInt();
                            scanner.nextLine();

                            manager.removeTask(index);
                        } else {
                            String name = scanner.nextLine();
                            manager.removeTask(name);
                        }
                    }
                    case 4 -> {
                        System.out.print("Enter task name or task number: ");

                        if (scanner.hasNextInt()) {
                            int index = scanner.nextInt();
                            scanner.nextLine();

                            manager.makeFinished(index);
                        } else {
                            String name = scanner.nextLine();
                            manager.makeFinished(name);
                        }
                    }
                    case 5 -> {
                        exit = true;
                        System.out.println("Exit...");
                    }
                    default -> {
                        System.out.println("Incorrect option number. Try again");
                    }
                }
            } else {
                scanner.nextLine();
                System.out.println("Wrong option number. Use from 1 to 5.");
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