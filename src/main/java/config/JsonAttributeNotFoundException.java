package config;

public class JsonAttributeNotFoundException extends Exception{
    public final String attributeName;

    public JsonAttributeNotFoundException(String attributeName) {
        super("This attribute " + attributeName + " was not found.");
        this.attributeName = attributeName;
    }
}
