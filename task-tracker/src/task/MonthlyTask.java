package task;

import java.time.LocalDate;

public class MonthlyTask extends Task{
    private final Integer id;
    public MonthlyTask(String title, Type type, LocalDate dateTime, String description) {
        super(title, type, dateTime, description);
        this.id = idGenerator;
    }

    @Override
    public boolean appearsIn(LocalDate inputDate, LocalDate dateTime) {
        return getDateTime().getDayOfMonth() == dateTime.getDayOfMonth ();
    }

    @Override
    public String toString() {
        return  "Monthly task. ID = "  + id + ". Title: " + getTitle() +
                "\n Description: " + getDescription() +
                "\n Date: " + getDateTime().getDayOfMonth() + " " + getDateTime().getMonth() +
                "\n Type of task: " + getType().getType() + "\n--------------------";
    }
}