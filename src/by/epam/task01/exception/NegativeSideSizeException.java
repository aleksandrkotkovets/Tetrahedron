package by.epam.task01.exception;

public class NegativeSideSizeException extends Exception {

    public NegativeSideSizeException() {
    }

    NegativeSideSizeException(String message) {
        super(message);
    }

    NegativeSideSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    NegativeSideSizeException(Throwable cause) {
        super(cause);
    }
}
