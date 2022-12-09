package controller;

import logger.LoggerConfig;
import model.Model;
import org.apache.log4j.Logger;

public abstract class Controller {

    private Model model;
    private Logger logger;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void processPetition(String msg) {
        if (LoggerConfig.isActive()) {

        }
        process(msg);
        model.processService(msg);
    }

    protected abstract void process(String info);
}
