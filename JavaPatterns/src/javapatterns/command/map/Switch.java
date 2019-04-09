package javapatterns.command.map;
import java.util.HashMap;
import java.util.Map;

public class Switch {
    
    //Invoker(вызывающий)-отдает запрос на выполнения вызывая execute
    Map<String,Command> actions = new HashMap();
    public void setCommand(String operation, Command cmd){
        actions.put(operation, cmd);
    }


    public void runCommand(String operation){
       actions.get(operation).execute();
    }

}
