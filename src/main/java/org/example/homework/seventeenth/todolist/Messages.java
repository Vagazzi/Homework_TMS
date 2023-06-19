package org.example.homework.seventeenth.todolist;

public class Messages {
    public static final String DEFAULT_MESSAGE = "Your current task list:";
    public static final String NEW_MESSAGE = "New to-do list:";

    public static final String TASK_PRIORITY_MESSAGE = """
            Enter the task priority, where:
            1) 1 - Low priority,
            2) 2 - Medium priority,
            3) 3 - High priority.
            """;
    public static final String COMPLETION_STATUS_MESSAGE = """
            Enter the task status, where:
            1) 1 - task not completed,
            2) 2 - task in process,
            3) 3 - task is completed.
            """;

    public static final String REMOVING_MESSAGE = """
                Enter the position:
                1) 1 - Delete requested element,
                2) 2 - Delete all positions.
                """;
    public static final String MENU_MESSAGE = """
                    1) Add a task;
                    2) Print all tasks;
                    3) Delete task;
                    4) Edit information;
                    5) Write into file;
                    6) Read from file;
                    0) Exit out of the program.
                    """;

    public static final String REMOVING_EVERYTHING_MESSAGE = """
                    Are you sure to delete everything from to-do list?
                    Type "Yes" or "No".
                """;
}
