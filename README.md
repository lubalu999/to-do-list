# Task Manager

## Description

A Java console application for managing a To-Do List. It allows users to add, view, delete tasks, mark them as completed, and save the task list to a file.

## Features

- Add a new task with priority (High, Medium, Low).

- View the task list.

- Delete a task by name or number.

- Mark a task as completed.

- Save the task list to a file and load it on application startup.

## Build and Run

### Clone the repository:
```
git clone <repository-link>
cd to-do-list
```
### Compile and run the application:
```
javac -d out -cp src $(find src -name "*.java")
java -cp out Main
```

## Usage

After starting the application, the console will prompt you to:

Create a new task list or load an existing one from a file.

### Choose an action from the menu:

- Add a task

- Show task list

- Delete a task

- Mark a task as completed

- Save tasks to a file

- Exit

## Data Storage Format

Tasks are saved in a JSON file using the Jackson library.
