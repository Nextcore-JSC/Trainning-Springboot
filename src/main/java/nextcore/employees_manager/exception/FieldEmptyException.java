package nextcore.employees_manager.exception;

public class FieldEmptyException extends RuntimeException {
    public FieldEmptyException(String fieldName) {
        super(fieldName + " trống");
    }
}