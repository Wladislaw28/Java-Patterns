package javapatterns;

public class SingletonApp {
    
    public static void main(String[] args) throws InterruptedException {
        
        final int SIZE = 1000;
        
        Thread t[] = new Thread[SIZE];
        for (int i = 0; i < SIZE; i++) {
            t[i] = new Thread(new R());
            t[i].start();
        }
        for (int i = 0; i < SIZE; i++) {
            t[i].join();
        }
        System.out.println(Singleton.counter);
    }
    
}

class R implements Runnable{  //вызывает Singleton в нескольких потоках одновременно
    @Override
    public void run(){
        Singleton.getInstance();
    }
}

class Singleton{
    public static int counter = 0;
    private static volatile Singleton inctance = null; //volatile - с разделяемыми ресурсами 
    private Singleton(){
        counter++;
    }
    
//ленивая инцелизация - по требованию getInstance
    
public static Singleton getInstance(){
    if (inctance == null) {
        synchronized(Singleton.class){
            if (inctance == null) 
                inctance = new Singleton();
             }
    }
        return inctance;
    }
}
            
    
