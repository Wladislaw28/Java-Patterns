package javapatterns.command.map;
import javapatterns.command.map.Command;
import javapatterns.command.map.FireTable;
import javapatterns.command.map.Light;
import javapatterns.command.map.Switch;
import javapatterns.command.map.TurnOff;
import javapatterns.command.map.TurnOffFire;
import javapatterns.command.map.TurnOn;
import javapatterns.command.map.TurnOnFire;


public class Main {
    
    public static void main(String[] args) {
        Light l1 = new Light();
        Switch l=new Switch();
        FireTable f = new FireTable();
        l.setCommand("Create", new TurnOn(l1));
        l.setCommand("Delete", new TurnOff(l1));
        l.setCommand("Start Fire", new TurnOnFire(f));
        l.setCommand("End Fire", new TurnOffFire(f));
        l.runCommand("Create");
      
        l.runCommand("Start Fire");
        l.runCommand("End Fire");
        l.runCommand("Delete");


    }
}
