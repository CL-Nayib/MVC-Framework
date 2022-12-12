package config.mvc;

import java.util.HashMap;

public class TransactionPool {

    private HashMap<String, TransactionMVC> transactionPool = new HashMap<>();

    public void addTransaction(String transactionName, TransactionMVC transactionMVC) {
        transactionPool.put(transactionName, transactionMVC);
    }

    public TransactionMVC getTransaction(String transactionName) {
        return transactionPool.get(transactionName);
    }


}
