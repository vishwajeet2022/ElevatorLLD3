package org.example;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem implements ObservableLiftSystem{
    private static ElevatorSystem INSTANCE;
    List<Elevator> elevatorList;

    private ElevatorSystem(){
        this.elevatorList = new ArrayList<>();
    }

    public static ElevatorSystem getInstance(){
        if(INSTANCE==null){
            synchronized (ElevatorSystem.class){
                if(INSTANCE==null){
                    INSTANCE = new ElevatorSystem();
                }
            }
        }

        return INSTANCE;
    }

    @Override
    public void addElevator(Elevator elevator) {
        elevatorList.add(elevator);
    }

    @Override
    public void requestElevator(int floor,Direction direction) throws InterruptedException {
        Request request = new Request(floor,direction);
        notifyElevator(request);

    }

    @Override
    public void notifyElevator(Request request) throws InterruptedException {
        Elevator elevator = findClosestElevator(request);
       if(elevator!=null){
           elevator.update(request);
       }
    }

    public Elevator findClosestElevator(Request request){
        Elevator closestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for(Elevator elevator : elevatorList){
            if(elevator.canhandleRequest(request)){
                int distance = Math.abs(elevator.getCurrentFloor())- request.getFloor();
                if(distance<minDistance){
                    closestElevator = elevator;
                    minDistance = distance;
                }
            }
        }

        return closestElevator;

    }
}
