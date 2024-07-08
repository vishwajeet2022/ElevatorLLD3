package org.example;

public class MovingUpState implements ElevatorState {
    Elevator elevator;
    public MovingUpState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void handleRequest(Request request) throws InterruptedException {
        if(request.getFloor()>elevator.getCurrentFloor()){
            int distance = request.floor-elevator.getCurrentFloor();
//            Thread.sleep(distance*1000);
            elevator.setCurrentFloor(request.getFloor());
            System.out.println("Elevator reached to "+elevator.getCurrentFloor()+" "+elevator.getId());
            if(elevator.getDestination().isEmpty()){
                elevator.setElevatorState(new IdleState(elevator));
            }
        }
    }
}
