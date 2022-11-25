package example;

import controller.Controller;

public class ExampleController extends Controller {
    @Override
    protected void process(String info) {
        System.out.println("Processing msg: "+info);
    }
}
