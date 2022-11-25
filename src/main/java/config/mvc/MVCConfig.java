package config.mvc;

import config.Configuration;

import java.util.Objects;

public class MVCConfig extends Configuration {
    private final String transactionName;
    private final String controllerClass;
    private final String modelClass;
    private final String functionName;
    private final String viewName;

    public MVCConfig(String transactionName, String controllerClass, String modelClass, String functionName, String viewName) {
        this.transactionName = transactionName;
        this.controllerClass = controllerClass;
        this.modelClass = modelClass;
        this.functionName = functionName;
        this.viewName = viewName;
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

    public String getViewName() {
        return viewName;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MVCConfig)) return false;

        boolean isSameTransaction = Objects.equals(transactionName, ((MVCConfig) obj).transactionName);
        boolean isSameController = Objects.equals(controllerClass, ((MVCConfig) obj).controllerClass);
        boolean isSameModel = Objects.equals(modelClass, ((MVCConfig) obj).modelClass);
        boolean isSameFunction = Objects.equals(functionName, ((MVCConfig) obj).functionName);
        boolean isSameView = Objects.equals(viewName, ((MVCConfig) obj).viewName);

        return isSameTransaction && isSameController && isSameModel && isSameFunction && isSameView;
    }
}
