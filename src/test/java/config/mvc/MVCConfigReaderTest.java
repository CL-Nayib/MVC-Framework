package config.mvc;

import config.JsonAttributeNotFoundException;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class MVCConfigReaderTest {

    private static MVCConfigReader reader;

    @Test
    @Description("Should read mvcConfig.json")
    void readMvcConfigFile() {
        assertDoesNotThrow(() -> {
            try {
                reader = new MVCConfigReader("src/main/resources/mvcConfig.json");
            } catch (JsonAttributeNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    @Description("Should thrown File not found exception")
    void throwFileNotFoundException() {
        assertThrows(
                FileNotFoundException.class,
                () -> reader = new MVCConfigReader("mvcConfig.json")
        );
    }

    @Test
    @Description("Should thrown Json Exception")
    void throwJsonExceptionBadArrayName() {
        assertThrows(
                JsonAttributeNotFoundException.class,
                () -> new MVCConfigReader("src/main/resources/badArrayNameMVC.json"),
                new JsonAttributeNotFoundException("MVC Config file").getMessage()
        );
    }

    @Test
    @Description("Should thrown Json Exception")
    void throwJsonExceptionIsNotArray() {
        assertThrows(
                JsonAttributeNotFoundException.class,
                () -> new MVCConfigReader("src/main/resources/isNotArrayMVC.json"),
                new JsonAttributeNotFoundException("mvcConfiguration").getMessage()
        );
    }

    @Test
    @Description("Should thrown Json Exception")
    void throwJsonExceptionBadAttributes() {
        assertThrows(
                JsonAttributeNotFoundException.class,
                () -> new MVCConfigReader("src/main/resources/isNotArrayMVC.json"),
                new JsonAttributeNotFoundException("mvcConfiguration").getMessage()
        );
    }
}
