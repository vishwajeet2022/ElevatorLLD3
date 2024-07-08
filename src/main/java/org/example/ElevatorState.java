package org.example;

public interface ElevatorState {
    void handleRequest(Request request) throws InterruptedException;
}
