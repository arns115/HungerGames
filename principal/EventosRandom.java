package principal;

import java.util.*;

public class EventosRandom extends Thread{
    int tipo;
    boolean exit=false;

    public void stop1(){
        exit=true;
    }
    public void run(){
        Random ran=new Random();
        int num=10;
        while(exit==false){
            int a=ran.nextInt(11);
            if(a==num){
                switch(tipo){
                    case 1:
                        System.out.println("Ha empezado a llover en la arena");
                        break;
                    case 2:
                        System.out.println("Ha empezado a granizar en la arena");
                        break;
                    case 3:
                        System.out.println("Se ha convertido en un dia muy soleado en la arena");
                        break;
                    default:
                    System.out.println("Inicializacion incorrecta de los hilos");
                }
            }
            
            try{
                Thread.sleep(5000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            
        }
    }
}
