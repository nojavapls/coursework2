package task;

import java.time.*;
import java.util.Objects;

public class OneTimeTask extends Task {

    private final Integer id;
    public OneTimeTask(String title, Type type, LocalDate dateTime, String description) {
        super(title, type, dateTime, description);
        this.id = idGenerator;
    }

    @Override
    public boolean appearsIn(LocalDate inputDate, LocalDate dateTime) {

        return Objects.equals(getDateTime(), dateTime);
    }

    @Override
    public String toString() {
        return "Onetime task. Id; " + id + ". Title: " +  getTitle() +
                "\n Description: " + getDescription() +
                "\n Date: " + getDateTime().getDayOfMonth() + " " + getDateTime().getMonth() + " " + getDateTime().getYear() +
                "\n Type: " + getType().getType();
    }
}
