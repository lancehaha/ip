package Tasks;

import enums.TaskType;

/**
 * Represents a generic task with a description and completion status.
 * This base class is extended by more specific task types that include additional properties and behaviors.
 */
public class Task {
    protected String description;  // Textual description of the task.
    protected boolean isDone;      // Completion status of the task.
    protected TaskType taskType;   // Type of the task, as defined in the TaskType enum.
    protected Integer priority;

    /**
     * Constructs a new Task with a specified description and type and a default priority.
     *
     * @param description The textual description of the task.
     * @param taskType The type of the task, indicating its category (e.g., TODO, DEADLINE, EVENT).
     */

    public Task(String description, TaskType taskType) {
        this(description, taskType, "100000");  // Default priority is set to 1.
    }

    /**
     * Constructs a new Task with a specified description and type.
     *
     * @param description The textual description of the task.
     * @param taskType The type of the task, indicating its category (e.g., TODO, DEADLINE, EVENT).
     * @param priority a integer specifies a priority
     */
    public Task(String description, TaskType taskType, String priority) {
        this.description = description;
        this.isDone = false;
        this.taskType = taskType;
        this.priority = Integer.valueOf(priority);
    }

    /**
     * Returns a status icon representing the task's completion status.
     * '[X]' indicates the task is completed, and '[ ]' indicates it is not.
     *
     * @return A string containing the status icon.
     */
    public String getStatusIcon() {
        return (isDone ? "[X]" : "[ ]");
    }

    /**
     * Updates the description of the task.
     *
     * @param description The new description to set for the task.
     */
    public void getDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the type of the task.
     *
     * @return The taskType enum value representing the category of the task.
     */
    public TaskType getTaskType() {
        return taskType;
    }

    /**
     * Provides a string representation of the task, including its completion status and description.
     *
     * @return A string detailing the task's status and description.
     */
    @Override
    public String toString() {
        String priorityString = priority != 100000 ? priority.toString() : "no priority";
        return getStatusIcon() + " " + description + " priority: " + priorityString;
    }

    /**
     * Marks the task as completed.
     */
    public void markDone() {
        isDone = true;
    }

    /**
     * Returns a formatted string suitable for file storage, including the task's completion status and description.
     *
     * @return A string formatted for file storage.
     */
    public String toFileFormat() {
        String marked = isDone ? "1" : "0";
        return " | " + marked + " | " + description;
    }

    /**
     * Marks the task as not completed.
     */
    public void unmarkDone() {
        isDone = false;
    }

    /**
     * update the content
     *
     * @param priority description
     * priority is an integer
     *
     */

    public void update(Integer priority) {
        this.priority = Integer.valueOf(priority);
    }

    /**
     * update the content
     * @param  description
     * description is a string
     */
    public void update(String description) {
        this.description = description;
    }

    /**
     * update the content
     * @param priority description
     * @param  description
     * description is a string, priority is an integer
     */
    public void update(String description, Integer priority) {
        this.description = description;
        this.priority = priority;
    }
}
