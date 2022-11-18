package config.mvc;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import config.ConfigReader;
import config.JsonAttributeNotFoundException;

import java.io.FileNotFoundException;

public class MVCConfigReader extends ConfigReader {

    public MVCConfigReader(String fileName) throws JsonAttributeNotFoundException, FileNotFoundException {
        readFile(fileName);
        validateJsonFile();
    }

    @Override
    public MVCConfig[] getConfigurations(JsonArray jsonArray) {

        MVCConfig[] mvcConfigs = new MVCConfig[jsonArray.size()];

        for (int i = 0; i < jsonArray.size(); i++) {
            mvcConfigs[0] = parseJsonToConfigurationObject(
                    jsonArray.get(i).getAsJsonObject()
            );
        }

        return mvcConfigs;
    }

    @Override
    protected MVCConfig parseJsonToConfigurationObject(JsonObject json) {
        String transactionName = json.getAsJsonPrimitive("transactionName").getAsString();
        String controllerClass = json.getAsJsonPrimitive("controllerClass").getAsString();
        String modelClass = json.getAsJsonPrimitive("modelClass").getAsString();
        String functionName = json.getAsJsonPrimitive("functionName").getAsString();

        return new MVCConfig(transactionName, controllerClass, modelClass, functionName);
    }

    @Override
    protected void validateJsonFile() throws JsonAttributeNotFoundException {

        if ( jsonFile == null || !jsonFile.isJsonObject()) throw new JsonAttributeNotFoundException("MVC Config file");

        JsonElement jsonElement = jsonFile.getAsJsonObject().get("mvcConfiguration");
        if ( jsonElement == null || !jsonElement.isJsonArray()) throw new JsonAttributeNotFoundException("mvcConfiguration");

        JsonArray jsonArray = jsonElement.getAsJsonArray();

        for (JsonElement jsonConfig : jsonArray) {
            if (!jsonConfig.isJsonObject()) throw new JsonAttributeNotFoundException("MVCConfig object");
            JsonObject jsonObject = jsonConfig.getAsJsonObject();

            validateAttribute(jsonObject, "transactionName");
            validateAttribute(jsonObject, "controllerClass");
            validateAttribute(jsonObject, "modelClass");
            validateAttribute(jsonObject, "functionName");
        }
    }
}
