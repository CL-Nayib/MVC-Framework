package config;

import config.database.DatabaseConfig;
import config.database.DatabaseConfigReader;
import config.exceptions.JsonAttributeException;
import config.exceptions.JsonAttributeIsNotAnArrayException;
import config.exceptions.JsonAttributeIsNotPrimitiveException;
import config.exceptions.JsonAttributeNotFoundException;
import config.mvc.MVCConfig;
import config.mvc.MVCConfigReader;
import config.pool.PoolConfig;
import config.pool.PoolConfigReader;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class ConfigReaderTest {

    private static class ConfigTest {
        String one;
        String two;
        String three;

        public ConfigTest(String one, String two, String three) {
            this.one = one;
            this.two = two;
            this.three = three;
        }
    }

    private static class ConfigTestReader extends ConfigReader<ConfigTest> {

        public ConfigTestReader(String filePath, String configArrayName, String[] attributes) throws FileNotFoundException, JsonAttributeException {
            super(filePath, configArrayName, attributes);
        }

        @Override
        public ConfigTest[] getConfigurations() {
            return new ConfigTest[0];
        }
    }

    @Test
    @Description("Should read configurationFileTest.json")
    void readConfigFile() {
        assertDoesNotThrow(() -> {
            new ConfigTestReader(
                    "src/test/resources/config/configurationFileTest.json",
                    "configTest",
                    new String[] {
                            "one",
                            "two",
                            "three"
                    }
            );
        });
    }

    @Test
    @Description("Should thrown File not found exception")
    void throwFileNotFoundException() {
        assertThrows(
                FileNotFoundException.class,
                () -> new ConfigTestReader(
                        "src/test/resources/config/configTest.json",
                        "configTest",
                        new String[]{
                                "one",
                                "two",
                                "three"
                        })
        );
    }

    @Test
    @Description("Should thrown IllegalStateException")
    void throwIllegalStateException() {
        assertThrows(
                IllegalStateException.class,
                () -> new ConfigTestReader(
                        "src/test/resources/config/badJsonConfigFile.json",
                        "configTest",
                        new String[]{
                                "one",
                                "two",
                                "three"
                        })
        );
    }

    @Test
    @Description("Should throw Json AttributeIsNotAnArrayException")
    void throwJsonAttributeIsNotAnArrayException() {
        assertThrows(
                JsonAttributeIsNotAnArrayException.class,
                () -> new ConfigTestReader(
                        "src/test/resources/config/jsonWithNoArray.json",
                        "configTest",
                        new String[]{
                                "one",
                                "two",
                                "three"
                        })
        );
    }

    @Test
    @Description("Should throw JsonAttributeNotFoundException")
    void throwJsonAttributeNotFoundException() {
        assertThrows(
                JsonAttributeNotFoundException.class,
                () -> new ConfigTestReader(
                        "src/test/resources/config/missingAttribute.json",
                        "configTest",
                        new String[]{
                                "one",
                                "two",
                                "three"
                        })
        );
    }

    @Test
    @Description("Should throw JsonAttributeIsNotPrimitiveException")
    void throwJsonAttributeIsNotPrimitiveException() {
        assertThrows(
                JsonAttributeIsNotPrimitiveException.class,
                () -> new ConfigTestReader(
                        "src/test/resources/config/badAttribute.json",
                        "configTest",
                        new String[]{
                                "one",
                                "two",
                                "three"
                        })
        );
    }

    @Test
    @Description("Should read the mvc config file and return an array")
    public void readMVCConfigFile() {
        assertDoesNotThrow(() -> {
            MVCConfigReader reader = new MVCConfigReader("src/test/resources/config/mvcConfig.json");
            Assertions.assertArrayEquals(new MVCConfig[] {
                    new MVCConfig(
                            "t",
                            "c",
                            "m",
                            "f",
                            "v"
                    )
            },reader.getConfigurations());

        });
    }

    @Test
    @Description("Should read the pool config file and return an array")
    public void readPoolConfigFile() {
        assertDoesNotThrow(() -> {
            PoolConfigReader reader = new PoolConfigReader("src/test/resources/config/poolConfig.json");
            Assertions.assertArrayEquals(new PoolConfig[] {
                    new PoolConfig(
                            0,
                            0,
                            "u",
                            "d"
                    )
            },reader.getConfigurations());

        });
    }

    @Test
    @Description("Should throw an IllegalArgumentException")
    public void sizeShouldBeZeroOrPositive() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new PoolConfigReader("src/test/resources/config/negativeSizePool.json")
        );
    }

    @Test
    @Description("Should read the database config file and return an array")
    public void readDatabaseConfigFile() {
        assertDoesNotThrow(() -> {
            DatabaseConfigReader reader = new DatabaseConfigReader("src/test/resources/config/databaseConfig.json");
            Assertions.assertArrayEquals(new DatabaseConfig[] {
                    new DatabaseConfig(
                            "i",
                            "url",
                            "user",
                            "p"
                    )
            },reader.getConfigurations());

        });
    }
}
