package config.mvc;


import controller.Controller;
import model.Model;
import view.View;

import java.lang.reflect.Constructor;

public class TransactionFactory {

    public TransactionMVC createTransaction( String controller,String model, String view) throws Exception {
        TransactionMVC transaction = new TransactionMVC();
        transaction.setModel(createModel(model));
        transaction.setController(createController(controller));
        transaction.setView(createView(view));
        return transaction;

    }

    private Model createModel(String model) throws Exception {
        try {
            return (Model) instantiateClass(model);
        } catch (Exception e) {
          throw new Exception("Error creating model: " + e.getMessage());
        }
    }

    private Controller createController(String controller) throws Exception {
        try {
            return (Controller) instantiateClass(controller);
        } catch (Exception e) {
          throw new Exception("Error creating controller: " + e.getMessage());
        }
    }

    private View createView(String view) throws Exception {
        try {
            return (View) instantiateClass(view);
        } catch (Exception e) {
          throw new Exception("Error creating view: " + e.getMessage());
        }
    }

    private Object instantiateClass(String className) throws Exception {
        Class<?> clazz = Class.forName(className);
        Constructor constructor = clazz.getConstructor();
        Object obj = constructor.newInstance();
        return obj;
    }

    }
