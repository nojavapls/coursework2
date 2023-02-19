
import TaskTracker.TaskTracker;
import task.Task;
import java.util.*;

import static TaskTracker.TaskTracker.*;

public class Main {
    public static void main(String[] args) {

        System.out.printf("This is Task Program!\n");
        for (int i = 0; i < 2; i++) {
            TaskTracker.inputTask();
        }
        //c++ style lol
        TaskTracker.getAllByDate(getTaskMap(), inputDate()).forEach(System.out::println);;
    }
}