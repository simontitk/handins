import java.util.HashMap;

public class Task implements Comparable<Task> {

    private String description;
    private int priority;
    private int workload;
    private static final HashMap<Integer, String> priorities = new HashMap<>();
    static {
        priorities.put(1, "very important");
        priorities.put(2, "important");
        priorities.put(3, "unimportant");
        priorities.put(4, "after learn Portuguese");
    }


    public Task(String description, int priority, int workload) {

        this.description = description;

        if (!priorities.containsKey(priority)) {
            throw new InvalidPriorityException(priority);
        }

        this.priority = priority;

        if (workload < 0) {
            throw new InvalidWorkloadException(workload);
        }

        this.workload = workload;
    }


    public String toString() {
        return  this.description + 
                " takes " + 
                this.workload +
                " minutes" + 
                " and has priority " + 
                priorities.get(this.priority);
    }

    public int getPriority() {
        return this.priority;
    }

    public int getWorkload() {
        return this.workload;
    }


    @Override
    public int compareTo(Task otherTask) {
        int priorityComparison = (this.getPriority() - otherTask.getPriority());
        if (priorityComparison == 0 ) {
            return (this.getWorkload() - otherTask.getWorkload());
        }
        return priorityComparison;
    }

   
}