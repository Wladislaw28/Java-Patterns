
package javapatterns.command.map;

//Reciver(получатель)-выполняет операции,необходимые для выполнения запроса
public class Light {
    
    public void turnOn(){
        System.out.println("Turn On");
    }

    public void turnOff(){
        System.out.println("Turn Off");
    }
}
