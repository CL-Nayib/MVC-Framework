package config;

import com.google.gson.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public abstract class ConfigReader {

    private static Gson gsonInstance;

    protected static Gson gsonInstance() {
        if (gsonInstance == null) {
            gsonInstance = new GsonBuilder().setPrettyPrinting().create();
        }
        return gsonInstance;
    }

    abstract public Configuration[] getConfigurations();
    abstract protected Configuration parseJsonToConfigurationObject();
    abstract protected void validateJsonFile(JsonObject json, Class<Configuration> configurationClass) throws JsonAttributeNotFoundException;

    protected JsonElement jsonElement;

    protected final void readFile(String filename) {
        try (Reader reader = new FileReader(filename)) {
            jsonElement = gsonInstance().fromJson(reader, JsonElement.class);
        } catch (IOException e) {
            System.err.println("File not found");
            e.printStackTrace();
        }
    }
}
