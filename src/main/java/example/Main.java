package example;

import config.mvc.TransactionConfig;
import config.mvc.TransactionMVC;
import config.mvc.TransactionPool;
import controller.Controller;

public class Main {

    public void init (String route){
        try{
            TransactionConfig transactionConfig = new TransactionConfig();
            transactionConfig.readConfigFile(route);

            TransactionPool pool = transactionConfig.getTransactionPool();

            TransactionMVC mvc = pool.getTransaction("example");
            Controller controller = mvc.getController();
            controller.processPetition("Daniel");
            controller.processPetition("Gabo");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Main main = new Main();
        main.init("src/main/java/example/mvcConfig.json");
    }
}
