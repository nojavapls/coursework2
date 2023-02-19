package task;

import java.time.LocalDate;

public class YearlyTask extends Task {
    private final Integer id;
    public YearlyTask(String title, Type type, LocalDate dateTime, String description) {
        super(title, type, dateTime, description);
        this.id = idGenerator;
    }

    @Override
    public boolean appearsIn(LocalDate inputDate, LocalDate dateTime) {
        return inputDate.getDayOfMonth() == dateTime.getDayOfMonth() && inputDate.getMonth() == dateTime.getMonth();
    }

    @Override
    public String toString() {
        return  "Per year task. Id: " + id + ". Title: " + getTitle() +
                "\n Description: " + getDescription() +
                "\n Date: " + getDateTime().getDayOfMonth() + " " + getDateTime().getMonth() +
                "\n Type: " + getType().getType() ;
    }
}
