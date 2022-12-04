package config.pool;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import config.ConfigReader;
import config.exceptions.JsonAttributeException;

import java.io.FileNotFoundException;
import java.util.List;

public class PoolConfigReader extends ConfigReader<PoolConfig> {

    private static final String configArrayName = "poolConfig";

    public PoolConfigReader() throws JsonAttributeException, FileNotFoundException {
        this("config/poolConfig.json");
    }

    public PoolConfigReader(String filePath) throws JsonAttributeException, FileNotFoundException {
        super(
                filePath,
                configArrayName,
                new String[]{
                        "size",
                        "port",
                        "urlServer",
                        "databaseType"
                }
        );
    }

    @Override
    protected void validateAttribute(JsonObject json, String attributeName) throws JsonAttributeException, IllegalArgumentException{
        super.validateAttribute(json, attributeName);

        if (attributeName.equals("size")) {
            JsonElement element = json.get(attributeName);
            int size = element.getAsInt();

            if (size < 0) throw new IllegalArgumentException("Size should be zero or positive");
        }
    }

    @Override
    public PoolConfig[] getConfigurations() {
        JsonElement array = jsonFile.getAsJsonObject().get(configArrayName);
        List<PoolConfig> configs = gson.fromJson(array, new TypeToken<>(){});
        return configs.toArray(new PoolConfig[0]);
    }
}
