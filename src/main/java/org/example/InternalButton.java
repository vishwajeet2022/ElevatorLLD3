package org.example;

import lombok.Data;
import lombok.SneakyThrows;

@Data
public class InternalButton implements Button{
    private final int floor;
    InternalButton(int floor){
        this.floor = floor;
    }
    @SneakyThrows
    @Override
    public void press() {
        ElevatorSystem.getInstance().requestElevator(floor,null);
    }
}
