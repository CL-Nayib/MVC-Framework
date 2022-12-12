package example;

import config.mvc.controller.Controller;
import config.logger.LoggerConfig;
import org.apache.log4j.Logger;

public class ExampleController extends Controller {
    Logger logger = LoggerConfig.createLogger(this.getClass());
    @Override
    protected void process(String info) {
        System.out.println("Processing msg: "+info);
    }
}
