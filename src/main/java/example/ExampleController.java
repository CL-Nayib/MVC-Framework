package example;

import controller.Controller;
import logger.LoggerConfig;
import org.apache.log4j.Logger;

public class ExampleController extends Controller {
    Logger logger = LoggerConfig.createLogger(this.getClass());
    @Override
    protected void process(String info) {
        System.out.println("Processing msg: "+info);
    }
}
