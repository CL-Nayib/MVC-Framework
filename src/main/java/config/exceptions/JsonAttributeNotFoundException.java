package config.exceptions;

public class JsonAttributeNotFoundException extends JsonAttributeException {
    public JsonAttributeNotFoundException(String attributeName) {
        super(attributeName, " was not found.");
    }
}