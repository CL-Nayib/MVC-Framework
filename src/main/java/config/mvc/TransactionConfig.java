package config.mvc;

import config.exceptions.JsonAttributeException;

import java.io.FileNotFoundException;

public class TransactionConfig {
    private MVCConfigReader reader;




    public void readConfigFile() {
        MVCConfig[] configurations;
        try {
            reader = new MVCConfigReader();
            configurations = reader.getConfigurations();
            configureTransaction(configurations[0].toString(), configurations[1].toString(),configurations[2].toString(),configurations[3].toString());
        } catch (JsonAttributeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void configureTransaction(String transactionName, String controller , String model, String view) throws Exception {

TransactionFactory transactionFactory = new TransactionFactory();
TransactionMVC transactionMVC = transactionFactory.createTransaction(controller,model,view);

    }
}
