package org.example;

public class ButtonFactory {
    public static Button createButton(int floor,Direction direction){
       if(direction==null){
           return new InternalButton(floor);
       }
       else if(direction==Direction.UP || direction==Direction.DOWN){
           return new ExternalButton(floor,direction);
       }
       return new NullButton();
    }
}
