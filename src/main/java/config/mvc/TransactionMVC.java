package config.mvc;

import controller.Controller;
import model.Model;
import view.View;



public class TransactionMVC {
View view;
Controller controller;
Model model;

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
