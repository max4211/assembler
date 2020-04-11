package exceptions;

public class ReflectionException extends RuntimeException {

    public ReflectionException(Exception e) {
        super(e.getMessage());
    }

    public ReflectionException() {
        super();
    }
}
