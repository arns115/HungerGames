package principal;

import java.awt.Color;
import java.util.*;

import javax.swing.JLabel;

public class EventosRandom extends Thread{
    int tipo;
    boolean exit;
    JLabel l;
    public EventosRandom(int tipo,JLabel l){
        this.tipo=tipo;
        this.l = l;
        exit=false;
    }

    public void stop1(){
        exit=true;
    }
    public void run(){
        Random ran=new Random();
        int num=10;
        while(exit){
            int a=ran.nextInt(11);
            if(a>=num){
                switch(tipo){
                    case 1:
                        l.setText("Ha empezado a llover en la arena");
                        l.setForeground(Color.BLUE);
                        System.out.println("Ha empezado a llover en la arena");
                        break;
                    case 2:
                        l.setText("Ha empezado a granizar en la arena");
                        l.setForeground(Color.CYAN);
                        System.out.println("Ha empezado a granizar en la arena");
                        break;
                    case 3:
                        l.setText("Se ha convertido en un dia muy soleado en la arena");
                        l.setForeground(Color.orange);
                        System.out.println("Se ha convertido en un dia muy soleado en la arena");
                        break;
                    default:
                        System.out.println("Inicializacion incorrecta de los hilos");
                }
            }
            
            
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            
        }
    }
}
