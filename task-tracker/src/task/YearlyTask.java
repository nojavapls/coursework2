package task;

import exceptions.IncorrectArgumentException;

import java.time.LocalDate;

public class YearlyTask extends Task {
    private final Integer id;
    public YearlyTask(String title, Type type, LocalDate dateTime, String description) throws IncorrectArgumentException {
        super(title, type, dateTime, description);
        this.id = idGenerator;
    }

    @Override
    public boolean appearsIn(LocalDate dateTime) {
        return this.getDateTime().getDayOfMonth() == dateTime.getDayOfMonth() && this.getDateTime().getMonth() == dateTime.getMonth();
    }

    @Override
    public String toString() {
        return  "Per year task. Id: " + id + ". Title: " + getTitle() +
                "\n Description: " + getDescription() +
                "\n Date: " + getDateTime().getDayOfMonth() + " " + getDateTime().getMonth() +
                "\n Type: " + getType().getType() ;
    }
}
