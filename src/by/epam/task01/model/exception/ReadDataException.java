package by.epam.task01.model.exception;

public class ReadDataException extends Exception {

    public ReadDataException () {
        super();
    }

    public ReadDataException (String message, Throwable cause) {
        super(message, cause);
    }

    public ReadDataException (Throwable cause) {
        super(cause);
    }

    public ReadDataException (String message) { super(message); }
}
