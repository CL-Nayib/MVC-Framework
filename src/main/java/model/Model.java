package model;

import view.View;

public abstract class Model {
    private View view;

    public void setView(View view) {
        this.view = view;
    }

    public void notifyView(String msg) {
        view.handleNotification(msg);

    }

    public void processService(String msg) {
        service(msg);
        String data = getData();
        notifyView(data);
    }

    protected abstract void service(String info);
    protected abstract String getData();
}
