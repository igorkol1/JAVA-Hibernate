package pl.coderslab.dtos;

public class ValidationResponse {

    private String fieldKey;
    private String message;

    public ValidationResponse(String fieldKey, String message) {
        this.fieldKey = fieldKey;
        this.message = message;
    }

    public String getFieldKey() {
        return fieldKey;
    }

    public String getMessage() {
        return message;
    }
}
