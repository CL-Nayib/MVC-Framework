package config.exceptions;

public class JsonAttributeIsNotAnArrayException extends JsonAttributeException {
    public JsonAttributeIsNotAnArrayException(String attributeName) {
        super(attributeName, " is not an array");
    }
}
