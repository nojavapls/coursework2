package task;
import exceptions.IncorrectArgumentException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
public abstract class Task {

    public static int idGenerator;

    private String title;
    private Type type;
    private static int getIdGenerator = 0;
    private LocalDate dateTime;
    private String description;
    private Integer id;

    public Task(String title, Type type, LocalDate dateTime, String description) throws IncorrectArgumentException {
        this.title = title;
        if (type.equals(Type.WORK) || type.equals(Type.PERSONAL))
            this.type = type;
        else
            throw new IncorrectArgumentException("Incorrect type: must be WORK or PERSONAL");
        this.dateTime = dateTime;
        this.description = description;
        idGenerator += 1;
        this.id = idGenerator;
    }

    public Type getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return id == task.id && title.equals(task.title) && type.equals(task.type) && dateTime.equals(task.dateTime) && description.equals(task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, id, dateTime, description);
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }


    public abstract boolean appearsIn(LocalDate inputDate, LocalDate dateTime);


    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", type=" + type +
                ", id=" + id +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                '}';
    }

}

