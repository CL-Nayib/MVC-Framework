package example;

import model.Model;

public class ExampleModel extends Model {
 private String data;

    @Override
    protected void service(String info) {
        data = "wazaaaa "+info;
    }

    @Override
    protected String getData() {
        return data;
    }
}
