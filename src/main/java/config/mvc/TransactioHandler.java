package config.mvc;

import controller.Controller;
import model.Model;
import view.View;

public class TransactioHandler {

    public static void conectMVC(TransactionMVC transactionMVC) {
        Controller controller = transactionMVC.getController();
        Model model = transactionMVC.getModel();
        View view = transactionMVC.getView();

        controller.setModel(model);
        model.setView(view);

    }
}
