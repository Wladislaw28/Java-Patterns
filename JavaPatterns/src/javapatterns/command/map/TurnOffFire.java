
package javapatterns.command.map;

public class TurnOffFire implements Command{
    
    //ConcreteCommand- выполняет нужный execute, активизируя операции получателя
    FireTable fireTable = new FireTable();
    public TurnOffFire (FireTable fireTable) {

        this.fireTable = fireTable;
    }

    public void execute(){
        fireTable.turnOff();
    }
}
