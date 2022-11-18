package config;

import com.google.gson.*;

import java.io.FileNotFoundException;
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

    abstract public Configuration[] getConfigurations(JsonArray jsonArray);
    abstract protected Configuration parseJsonToConfigurationObject(JsonObject json);
    abstract protected void validateJsonFile() throws JsonAttributeNotFoundException;

    protected JsonElement jsonFile;

    protected final void readFile(String filename) throws FileNotFoundException {
        Reader reader = new FileReader(filename);
        jsonFile = gsonInstance().fromJson(reader, JsonElement.class);
    }

    protected final void validateAttribute(JsonObject object, String attributeName) throws JsonAttributeNotFoundException {
        JsonElement element = object.get(attributeName);
        if (jsonFile.isJsonPrimitive()) return;
        throw new JsonAttributeNotFoundException(attributeName);
    }
}
