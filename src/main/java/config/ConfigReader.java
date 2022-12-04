package config;

import com.google.gson.*;
import config.exceptions.JsonAttributeException;
import config.exceptions.JsonAttributeIsNotAnArrayException;
import config.exceptions.JsonAttributeIsNotPrimitiveException;
import config.exceptions.JsonAttributeNotFoundException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public abstract class ConfigReader<Configuration> {

    abstract public Configuration[] getConfigurations();
    
    protected final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    protected JsonElement jsonFile;

    public ConfigReader(String filePath, String configArrayName, String[] attributes) throws FileNotFoundException, JsonAttributeException {
        readFile(filePath);
        validateFile(configArrayName, attributes);
    }

    protected final void readFile(String filePath) throws FileNotFoundException {
        Reader reader = new FileReader(filePath);
        jsonFile = gson.fromJson(reader, JsonElement.class);
    }

    protected void validateFile(String configArrayName, String[] attributes) throws IllegalStateException, JsonAttributeException {
        validateObject(jsonFile);

        JsonObject jsonObject = jsonFile.getAsJsonObject();
        validateArray(jsonObject, configArrayName);

        for (JsonElement jsonElement : jsonObject.get(configArrayName).getAsJsonArray()) {

            validateObject(jsonElement);

            JsonObject configJsonObject = jsonElement.getAsJsonObject();

            for (String attribute : attributes) {
                validateAttribute(configJsonObject, attribute);
            }
        }
    }

    protected final void validateArray(JsonObject json, String arrayName) throws JsonAttributeException {
        if (!json.has(arrayName)) {
            throw new JsonAttributeNotFoundException(arrayName);
        }

        JsonElement element = json.get(arrayName);

        if (!element.isJsonArray()) {
            throw new JsonAttributeIsNotAnArrayException(arrayName);
        }
    }

    protected final void validateObject(JsonElement json) throws IllegalStateException {
        if (!json.isJsonObject()) {
            throw new IllegalStateException("A json object was required, but no object was found");
        }
    }

    protected void validateAttribute(JsonObject json, String attributeName) throws JsonAttributeException {
        if (!json.has(attributeName)) {
            throw new JsonAttributeNotFoundException(attributeName);
        }

        JsonElement element = json.get(attributeName);

        if (!element.isJsonPrimitive()) {
            throw new JsonAttributeIsNotPrimitiveException(attributeName);
        }
    }
}
