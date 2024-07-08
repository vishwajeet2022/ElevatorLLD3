package org.example;

import lombok.Data;

@Data
public class ExternalButton implements Button{

    private final Direction direction;
    private final int floor;

    ExternalButton(int floor,Direction direction){
        this.floor = floor;
        this.direction = direction;
    }
    @Override
    public void press() throws InterruptedException {
        ElevatorSystem.getInstance().requestElevator(floor,direction);
    }
}
