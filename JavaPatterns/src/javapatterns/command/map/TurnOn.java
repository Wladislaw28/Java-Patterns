
package javapatterns.command.map;

public class TurnOn implements Command{
    
    //ConcreteCommand- выполняет нужный execute, активизируя операции получателя
    Light light;
    public TurnOn(Light light){
        this.light = light;
    }


    public void execute(){
        light.turnOn();
    }
}
