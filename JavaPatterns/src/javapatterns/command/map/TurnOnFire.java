package javapatterns.command.map;

public class TurnOnFire implements Command{
     
    //ConcreteCommand- выполняет нужный execute, активизируя операции получателя
    FireTable fireTable = new FireTable();

    public TurnOnFire (FireTable fireTable) {
        this.fireTable = fireTable;
    }

    public void execute(){
        fireTable.turnOn();
    }

}
