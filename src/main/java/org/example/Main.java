package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        ElevatorSystem elevatorSystem = ElevatorSystem.getInstance();
        Elevator elevator1 = new Elevator(1);
        Elevator elevator2 = new Elevator(2);
        Elevator elevator3 = new Elevator(3);

        elevatorSystem.addElevator(elevator1);
        elevatorSystem.addElevator(elevator2);
        elevatorSystem.addElevator(elevator3);

        Button internalButton1 = ButtonFactory.createButton(3,null);
        internalButton1.press();
        Button internalButton2 = ButtonFactory.createButton(5,null);
        internalButton2.press();
        Button internalButton3 = ButtonFactory.createButton(8,null);
        internalButton3.press();
        Button internalButton4 = ButtonFactory.createButton(10,null);
        internalButton4.press();

        Button externalButton1 = ButtonFactory.createButton(6,Direction.DOWN);
        externalButton1.press();


    }
}