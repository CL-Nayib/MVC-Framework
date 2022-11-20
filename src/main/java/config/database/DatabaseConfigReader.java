package config.database;

import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import config.ConfigReader;
import config.exceptions.JsonAttributeException;

import java.io.FileNotFoundException;
import java.util.List;

public class DatabaseConfigReader extends ConfigReader<DatabaseConfig> {

    private static final String configArrayName = "databaseConfiguration";

    public DatabaseConfigReader() throws JsonAttributeException, FileNotFoundException {
        this("config/databaseConfig.json");
    }

    public DatabaseConfigReader(String filePath) throws JsonAttributeException, FileNotFoundException {
        super(
                filePath,
                configArrayName,
                new String[]{
                        "id",
                        "url",
                        "user",
                        "password"
                }
        );
    }

    @Override
    public DatabaseConfig[] getConfigurations() {
        JsonElement array = jsonFile.getAsJsonObject().get(configArrayName);
        List<DatabaseConfig> configs = gson.fromJson(array, new TypeToken<>(){});
        return configs.toArray(new DatabaseConfig[0]);
    }
}
