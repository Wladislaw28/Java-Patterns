package javapatterns;

public class DelegateApp {
    
    public static void main(String[] args) {
        Painter painter = new Painter();
        painter.setGraphics(new Circle());
        painter.draw();
        
        painter.setGraphics(new Triangle());
        painter.draw();
    }
}

interface Graphics{
    void draw();
}

class Circle implements Graphics{
    public void draw(){
        System.out.println("Risuem Circle");
    }
}
  
class Triangle implements Graphics{
    public void draw(){
        System.out.println("Risuem Triangle");
    }
}

class Square implements Graphics{
    public void draw(){
        System.out.println("Risuem Square");
    }
}

class Painter{
   Graphics graphics ;
   void setGraphics(Graphics g){
       graphics = g;
   }
   void draw(){
       graphics.draw();
   }
}
        