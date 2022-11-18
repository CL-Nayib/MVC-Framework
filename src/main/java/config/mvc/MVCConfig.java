package config.mvc;

import config.Configuration;

public class MVCConfig extends Configuration {
    private final String transactionName;
    private final String controllerClass;
    private final String modelClass;
    private final String functionName;

    public MVCConfig(String transactionName, String controllerClass, String modelClass, String functionName) {
        this.transactionName = transactionName;
        this.controllerClass = controllerClass;
        this.modelClass = modelClass;
        this.functionName = functionName;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public String getControllerClass() {
        return controllerClass;
    }

    public String getModelClass() {
        return modelClass;
    }

    public String getFunctionName() {
        return functionName;
    }
}
