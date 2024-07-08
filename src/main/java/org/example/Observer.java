package org.example;

public interface Observer {
    void update(Request request) throws InterruptedException;
}
