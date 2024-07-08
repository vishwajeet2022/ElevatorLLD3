package org.example;

public class IdleState implements ElevatorState{
    Elevator elevator;

    IdleState(Elevator elevator){
        this.elevator = elevator;
    }
    @Override
    public void handleRequest(Request request) throws InterruptedException {
        if(this.elevator.getCurrentFloor()> request.getFloor()){
            elevator.setElevatorState(new MovingDownState(elevator));
        }
        else if(this.elevator.getCurrentFloor()< request.getFloor()){
            elevator.setElevatorState(new MovingUpState(elevator));
        }

        elevator.addRequest(request);
    }
}
