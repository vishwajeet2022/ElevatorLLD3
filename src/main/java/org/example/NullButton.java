package org.example;

public class NullButton implements Button{
    @Override
    public void press() {
        System.out.println("Wrong button type");
    }
}
