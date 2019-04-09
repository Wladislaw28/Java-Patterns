
package javapatterns.command.map;

public class TurnOff implements Command{
    
    //ConcreteCommand- выполняет нужный execute, активизируя операции получателя
    Light light;
    public TurnOff(Light light){
        this.light = light;
    }


    public void execute(){
        light.turnOff();
    }
}
