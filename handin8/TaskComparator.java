import java.util.Comparator;

public class TaskComparator implements Comparator<Task> {

    public int compare(Task task1, Task task2) {
        int priorityComparison = (task1.getPriority() - task2.getPriority());
        if (priorityComparison == 0 ) {
            return (task1.getWorkload() - task2.getWorkload());
        }
        return priorityComparison;
    }
}