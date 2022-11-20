package config.exceptions;

public class JsonAttributeException extends Exception {
    public final String attributeName;
    public final String constMessage;

    public JsonAttributeException(String attributeName, String constMessage) {
        super("This attribute " + attributeName + constMessage);
        this.attributeName = attributeName;
        this.constMessage = constMessage;
    }
}
