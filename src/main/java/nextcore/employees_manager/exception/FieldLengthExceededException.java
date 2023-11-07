package nextcore.employees_manager.exception;

public class FieldLengthExceededException extends RuntimeException {
    public FieldLengthExceededException(String fieldName) {
        super(fieldName + " quá dài");
    }
}
