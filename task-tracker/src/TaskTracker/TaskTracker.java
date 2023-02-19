package TaskTracker;
import task.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class TaskTracker {
    public static final String DATE_FORMAT = "dd.MM.yyyy";
    private final static HashMap<Integer, Task> taskMap = new HashMap<>();
    private final static HashMap<Integer, Task> deletedTaskMap = new HashMap<>();

    public static HashMap<Integer, Task> getTaskMap() {return taskMap;}
    public static HashMap<Integer, Task> getDeletedTaskMap() {return deletedTaskMap;}


    public static void add(Task task){
        getTaskMap().put(task.getId(), task);
    }

    public static LocalDate inputDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter date to check tasks (format: dd.MM.yyyy):");
        return LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern(DATE_FORMAT));
    }

    // much helb here https://www.reddit.com/r/javahelp/comments/5r292t/cant_use_collecttolist_with_streams/
    public static Collection<Task> getAllByDate(HashMap<Integer, Task> taskMap, LocalDate taskDate) {
        Stream<Task> str = taskMap.values().stream();
        return str.filter(s -> s.appearsIn(taskDate, s.getDateTime())).collect(Collectors.toList());
    }

    public static void getDeleted() {
        System.out.println(Arrays.toString(deletedTaskMap.entrySet().toArray()));

    }
    public static void inputTask() {
        Type taskType;
        Scanner scanner = new Scanner(System.in);
        System.out.println("TYPE: enter number 1 or 2:\n1.WORK TASK;\n2.PERSONAL TASK");
        taskType = (scanner.nextInt() == 1 ? Type.WORK : Type.PERSONAL);

        System.out.print("dd.MM.yyyy date for task:");
        LocalDate dateTime = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern(DATE_FORMAT));

        System.out.println("Choose the type:\n 1. One time task \n 2. Everyday task \n 3. Per week task \n 4. Per month task \n 5. Per year task");
        Integer taskDateType = scanner.nextInt();
        System.out.println("Enter title, description:");
        switch (taskDateType) {

            case 1:
                add(new OneTimeTask(scanner.next(), taskType, dateTime, scanner.next()));
                break;
            case 2:
                add(new DailyTask(scanner.next(), taskType, dateTime, scanner.next()));
                break;
            case 3:
                add(new WeeklyTask(scanner.next(), taskType, dateTime, scanner.next()));
                break;
            case 4:
                add(new MonthlyTask(scanner.next(), taskType, dateTime, scanner.next()));
                break;
            case 5:
                add(new YearlyTask(scanner.next(), taskType, dateTime, scanner.next()));
                break;
            default: {
                System.out.println("Incorrect number: enter in range 1-5.");
            }
        }
        System.out.println("Task added!");
    }

    public static void removeTaskId() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter task ID to delete: ");
        Integer id = scanner.nextInt();
        Task removedTask = getTaskMap().get(id);
        deletedTaskMap.put(removedTask.getId(), removedTask);
        getTaskMap().remove(id);
        System.out.println("Task id " + id + "moved to Deleted List.");
    }

}
