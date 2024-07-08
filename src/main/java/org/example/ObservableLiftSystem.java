package org.example;

public interface ObservableLiftSystem {
    void addElevator(Elevator elevator);
    void requestElevator(int floor,Direction direction) throws InterruptedException;
    void notifyElevator(Request request) throws InterruptedException;
}
