package config.exceptions;

public class JsonAttributeIsNotPrimitiveException extends JsonAttributeException {
    public JsonAttributeIsNotPrimitiveException(String attributeName) {
        super(attributeName, " is not a primitive type.");
    }
}