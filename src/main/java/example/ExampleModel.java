package example;

import config.mvc.model.Model;

public class ExampleModel extends Model {
 private String data;

    @Override
    protected void service(String info) {
        data = "hola "+info;
    }

    @Override
    protected String getData() {
        return data;
    }
}
