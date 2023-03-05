package exceptions;

public class TaskNotFoundException extends IllegalArgumentException {
    public TaskNotFoundException(String text){
        super(text);
    }
}