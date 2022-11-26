package config.mvc;

import config.exceptions.JsonAttributeException;

import java.io.FileNotFoundException;

public class TransactionConfig {
    private TransactionPool transactionPool = new TransactionPool();
    private MVCConfigReader reader;


    public void readConfigFile(String filePath) {
        MVCConfig[] configurations;
        try {
            reader = new MVCConfigReader(filePath);
            configurations = reader.getConfigurations();
            System.out.println(configurations[0].getControllerClass());
            configureTransaction(configurations[0].getTransactionName(),configurations[0].getControllerClass(),configurations[0].getModelClass(),configurations[0].getViewName());
        } catch (JsonAttributeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void configureTransaction(String transactionName, String controller, String model, String view) throws Exception {

        TransactionFactory transactionFactory = new TransactionFactory();
        TransactionMVC transactionMVC = transactionFactory.createTransaction(controller, model, view);
        TransactioHandler.conectMVC(transactionMVC);
        transactionPool.addTransaction(transactionName, transactionMVC);
    }

    public TransactionPool getTransactionPool() {
        return transactionPool;
    }
}
