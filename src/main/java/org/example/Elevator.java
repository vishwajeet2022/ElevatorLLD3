package org.example;

import lombok.Data;

import java.util.TreeSet;

@Data
public class Elevator implements Observer{
    int currentFloor;
    int id;
    ElevatorState elevatorState;
    TreeSet<Integer> destination;

    Elevator(int id){
        this.id = id;
        this.currentFloor = 0;
        this.elevatorState = new IdleState(this);
        this.destination = new TreeSet<>();
    }


    @Override
    public void update(Request request) throws InterruptedException {
        addRequest(request);
    }

    public void addRequest(Request request) throws InterruptedException {
        this.destination.add(request.floor);
        elevatorState.handleRequest(request);
    }


    public boolean canhandleRequest(Request request){
        if(request.getDirection()==null){
            return true;
        }
        else if(this.elevatorState instanceof IdleState){
            return true;
        }
        else if(this.elevatorState instanceof MovingUpState && request.getDirection()==Direction.UP){
            return request.getFloor()>this.getCurrentFloor();
        }
        else if(this.elevatorState instanceof MovingDownState && request.getDirection()==Direction.DOWN){
            return request.getFloor()<this.getCurrentFloor();
        }

        return true;
    }

}
