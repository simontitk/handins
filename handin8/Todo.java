import java.util.ArrayList;
import java.util.List;

public class Todo {

    private List<Task> tasks;
    private int totalWork;

    public Todo() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String description, int priority, int minutes) {

        try {
            Task task = new Task(description, priority, minutes);
            this.tasks.add(task);
        } 
        catch (InvalidPriorityException e) {
            System.out.println(description + " has invalid priority");
        }
        catch (InvalidWorkloadException e) {
            System.out.println(description + " has invalid workload");
        }
    }

    public void print() {
        System.out.println("Todo:\n-----");
        if (this.tasks.isEmpty()) {
            System.out.println("You're all done for today! #TodoZero");
        }
        else {
            this.tasks.forEach(System.out::println);
            
        }
        if (this.totalWork > 0) {
            System.out.println(this.totalWork + " minutes of work done!");
        }
    }

    public void completeTask(int index) {
        try {
            this.totalWork += this.tasks.get(index).getWorkload();
            this.tasks.remove(index);
        } 
        catch (Exception e) {
           System.out.println("Invalid index");
        }
    }

    public void printPriority(int limit) {
        boolean hadTask = false;
        System.out.println("Filtered todo:\n--------------");
        for (Task task: tasks) {
            if (task.getPriority() <= limit) {
                hadTask = true;
                System.out.println(task);
            }
        }
        if (!hadTask) {
            System.out.println("No tasks with given priority");
        }
    }

    public void printPrioritized() {

        var sortedTasks = this.tasks;
        sortedTasks.sort(new TaskComparator());
        System.out.println("Prioritized todo:\n-----------------");
        for (Task task: sortedTasks) {
            System.out.println(task);
        }
    }
}