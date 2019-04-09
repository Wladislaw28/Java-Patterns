package javapatterns.command.map;

//Reciver(получатель)-выполняет операции,необходимые для выполнения запроса
public class FireTable {
    
    public void turnOn(){
        System.out.println("Start fire");
    }
    public void turnOff(){
        System.out.println("End fire");
    }
}
