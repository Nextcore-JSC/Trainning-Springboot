package nextcore.employees_manager.exception;

public class FieldFormatException extends RuntimeException {
    private String code;
    private String message;

    public FieldFormatException(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"code\": " + code + ",\n" +
                "  \"message\": {\n" +
                "    \"code\": \"" + code + "\",\n" +
                "    \"message\": \"" + message + "\"\n" +
                "  }\n" +
                "}";
    }
}