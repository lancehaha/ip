package Tasks;

import enums.TaskType;

import java.time.format.DateTimeFormatter;

public class Todo extends Task {

    public Todo(String description) {
        super(description, TaskType.TODO);
    }

    @Override
    public String toFileFormat() {
        return "T" + super.toFileFormat();
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
