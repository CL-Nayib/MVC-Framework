package config.mvc;

import config.mvc.controller.Controller;
import config.mvc.model.Model;
import config.mvc.view.View;

public class TransactioHandler {

    public static void conectMVC(TransactionMVC transactionMVC) {
        Controller controller = transactionMVC.getController();
        Model model = transactionMVC.getModel();
        View view = transactionMVC.getView();

        controller.setModel(model);
        model.setView(view);

    }
}
