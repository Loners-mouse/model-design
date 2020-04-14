package cn.model.mediator.client;

public interface Mediator {
    void send(String message, Colleague colleague);
}
