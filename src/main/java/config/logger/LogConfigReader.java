package config.logger;

import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import config.ConfigReader;
import config.exceptions.JsonAttributeException;

import java.io.FileNotFoundException;
import java.util.List;

public class LogConfigReader extends ConfigReader<LogModel> {

    private static final String configArrayName = "loggerConfiguration";

    public LogConfigReader() throws JsonAttributeException, FileNotFoundException {
        this("config/logConfig.json");
    }

    public LogConfigReader(String filePath) throws JsonAttributeException, FileNotFoundException {
        super(
                filePath,
                configArrayName,
                new String[]{
                        "active",
                        "maxFileSize",
                        "maxFiles"
                }
        );
    }

    @Override
    public LogModel[] getConfigurations() {
        JsonElement array = jsonFile.getAsJsonObject().get(configArrayName);
        List<LogModel> configs = gson.fromJson(array, new TypeToken<>() {
        });
        return configs.toArray(new LogModel[0]);
    }
}
