package config.mvc;

import config.mvc.controller.Controller;
import config.mvc.model.Model;
import config.mvc.view.View;


public class TransactionMVC {
    private View view;
    private Controller controller;
    private Model model;

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
