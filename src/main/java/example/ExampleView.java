package example;


import view.View;

public class ExampleView implements View {

    @Override
    public void handleNotification(String msg) {
        System.out.println(msg);
    }
}
