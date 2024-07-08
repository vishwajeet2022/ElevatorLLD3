package org.example;

public class MovingDownState implements ElevatorState {
    Elevator elevator;
    public MovingDownState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void handleRequest(Request request) throws InterruptedException {
        if(elevator.getCurrentFloor()> request.getFloor()){
            int distance = elevator.getCurrentFloor()-request.getFloor();
            Thread.sleep(1000*distance);
            elevator.setCurrentFloor(request.getFloor());
            System.out.println("Elevator "+elevator.getId()+" reached to floor "+elevator.getCurrentFloor());
            if(elevator.getDestination().isEmpty()){
                elevator.setElevatorState(new IdleState(elevator));
            }
        }
    }
}
