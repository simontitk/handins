public class InvalidPriorityException extends RuntimeException {

    public InvalidPriorityException(int i) {
        super(Integer.toString(i));
    } 
}
