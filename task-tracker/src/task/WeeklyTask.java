package task;

import java.time.LocalDate;

public class WeeklyTask extends Task{
    private final Integer id;
    public WeeklyTask(String title, Type type, LocalDate dateTime, String description) {
        super(title, type, dateTime, description);
        this.id = idGenerator;
    }

    @Override
    public boolean appearsIn(LocalDate inputDate, LocalDate dateTime) {
        return inputDate.getDayOfWeek() == dateTime.getDayOfWeek();
    }

    @Override
    public String toString() {
        return  "Per week task. Id: " + id + ". Title: " + getTitle() +
                "\n Description: " + getDescription() +
                "\n Date: every " + getDateTime().getDayOfWeek() +
                "\n Type: " + getType().getType();
    }
}
