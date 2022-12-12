package config.logger;

import config.exceptions.JsonAttributeException;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;

public class LoggerConfig {

    private static Logger logger;
    private static LogConfigReader reader;
    private static LogModel[] configurations;


    public static boolean isActive() {
        return configurations[0].isActive();
    }

    public static void readConfigFile(String filepath) {
        try {
            reader = new LogConfigReader(filepath);
            configurations = reader.getConfigurations();
        } catch (JsonAttributeException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static Logger createLogger(Class clazz) {

        logger = LogFactory.createLogger(clazz, configurations[0].getMaxFileSize(), configurations[0].getMaxFiles(), configurations[0].isActive());
        return logger;


    }
}
