package controller;

import model.Model;

public abstract class Controller {

    private Model model;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void processService(String msg) {
        process(msg);
        model.processService(msg);
    }

    protected abstract void process(String info);
}
