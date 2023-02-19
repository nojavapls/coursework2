
import TaskTracker.TaskTracker;
import task.Task;
import java.util.*;

import static TaskTracker.TaskTracker.*;

public class Main {
    public static void main(String[] args) {

        System.out.printf("This is Task Program!\nFirst, add some tasks to the TaskTracker App:");
        for (int i = 0; i < 2; i++) {
            TaskTracker.inputTask();
        }
        //c++ style lol
        Scanner scanner = new Scanner(System.in);
        System.out.println("Task Tracker Options\n 1.Add task\n2.Delete task\n3.Check date for tasks\n4.Get list of deleted tasks\nEnter option number");
            switch (scanner.nextInt()) {

                case 1:
                    TaskTracker.inputTask();
                    break;
                case 2:
                    TaskTracker.removeTaskId();
                    break;
                case 3:
                    TaskTracker.getAllByDate(getTaskMap(), inputDate()).forEach(System.out::println);
                    break;
                case 4:
                    TaskTracker.getDeleted();
                    break;
                default:
                    System.out.println("Incorrect option number. Enter within range 1-4.");
            }
        }
}