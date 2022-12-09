package logger;

import config.exceptions.JsonAttributeException;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;

public class LoggerConfig {

    private static Logger logger;
    private static LogConfigReader reader;
    private static LogModel[] configurations;

    private static String configFile;

    public static void setConfigFile(String filepath) {
        configFile = filepath;
    }

    public static Logger getLogger() {
        return logger;
    }

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
        if (configurations[0].isActive()) {
            logger = Logger.getLogger(clazz);
            return logger;
        } else {
            throw new RuntimeException("Logger is not active");
        }

    }
}
