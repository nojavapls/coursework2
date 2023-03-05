package task;

import exceptions.IncorrectArgumentException;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task {
    private final Integer id;
    public DailyTask(String title, Type type, LocalDate dateTime, String description) throws IncorrectArgumentException {
        super(title, type, dateTime, description);
        this.id = idGenerator;
    }

    @Override
    public boolean appearsIn(LocalDate dateTime) {
        return true;
    }

    @Override
    public String toString() {
        return  ("Everyday task. Id: "  + id + ". Title: "+ getTitle() +
                "\n Description: " + getDescription() +
                "\n Type: " + getType());
    }
}