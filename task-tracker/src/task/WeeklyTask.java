package task;

import exceptions.IncorrectArgumentException;

import java.time.LocalDate;

public class WeeklyTask extends Task{
    private final Integer id;
    public WeeklyTask(String title, Type type, LocalDate dateTime, String description) throws IncorrectArgumentException {
        super(title, type, dateTime, description);
        this.id = idGenerator;
    }

    @Override
    public boolean appearsIn(LocalDate dateTime) {
        return this.getDateTime().getDayOfWeek() == dateTime.getDayOfWeek();
    }

    @Override
    public String toString() {
        return  "Per week task. Id: " + id + ". Title: " + getTitle() +
                "\n Description: " + getDescription() +
                "\n Date: every " + getDateTime().getDayOfWeek() +
                "\n Type: " + getType().getType();
    }
}
