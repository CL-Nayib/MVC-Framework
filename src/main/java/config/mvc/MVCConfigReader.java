package config.mvc;

import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import config.ConfigReader;
import config.exceptions.JsonAttributeException;

import java.io.FileNotFoundException;
import java.util.List;

public class MVCConfigReader extends ConfigReader<MVCConfig> {

    private static final String configArrayName = "mvcConfiguration";

    public MVCConfigReader() throws JsonAttributeException, FileNotFoundException {
        this("config/mvcConfig.json");
    }

    public MVCConfigReader(String filePath) throws JsonAttributeException, FileNotFoundException {
        super(
                filePath,
                configArrayName,
                new String[]{
                        "transactionName",
                        "controllerClass",
                        "modelClass",
                        "functionName"
                }
        );
    }

    @Override
    public MVCConfig[] getConfigurations() {
        JsonElement array = jsonFile.getAsJsonObject().get(configArrayName);
        List<MVCConfig> configs = gson.fromJson(array, new TypeToken<>(){});
        return configs.toArray(new MVCConfig[0]);
    }
}
