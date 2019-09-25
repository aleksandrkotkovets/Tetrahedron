package by.epam.task01.model.exception;

public class ZeroSidesException extends Exception {



    public ZeroSidesException(String message) {
        super(message);
    }

    public ZeroSidesException(String message,Throwable cause) {
        super(message,cause);
    }

    public ZeroSidesException(Throwable cause) {
        super(cause);
    }
}
