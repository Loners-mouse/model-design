package cn.model.mediator.client;

public interface Colleague {

    void send(String message, Colleague colleague);

    void handler(String message, Colleague colleague);

}
