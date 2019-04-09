package javapatterns;



public class CommandApp {
    public static void main(String[] args) {
        Comp c = new Comp();
        User u = new User(new StartCommand(c), new StopCommand(c), new ResetCommand(c));
        
        u.startComputer();
        u.resetComputer();
        u.stopComputer();
    }
}

interface Command{
    public void execute();
}
//Reciver(получатель)-выполняет операции,необходимые для выполнения запроса
class Comp{
    void start(){
        System.out.println("Start");
    }
     void stop(){
        System.out.println("Stop");
    }
     void reset(){
        System.out.println("Reset");
    }
}
//ConcreteCommand- выполняет нужный execute, активизируя операции получателя
class StartCommand implements Command{
    Comp computer;
    public StartCommand(Comp computer){this.computer = computer;}
    @Override
    public void execute() {
       computer.start();
    }
}
class StopCommand implements Command{
    Comp computer;
    public StopCommand(Comp computer){this.computer = computer;}
    @Override
    public void execute() {
       computer.stop();
    }
}
class ResetCommand implements Command{
    Comp computer;
    public ResetCommand(Comp computer){this.computer = computer;}
    @Override
    public void execute() {
       computer.reset();
    }
}
//Invoker(вызывающий)-отдает запрос на выполнения вызывая execute
class User{
    Command start;
    Command stop;
    Command reset;
    public User(Command start, Command stop, Command reset){
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }
    void startComputer(){
    start.execute();
}
    void stopComputer(){
    stop.execute();
}
    void resetComputer(){
    reset.execute();
}
}







