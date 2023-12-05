package armas.Armas_especificas;

import armas.Arma;

public class arco extends Arma{
    private int flechas;

    public arco() {
        super(50,10,70,20,40,20);
        this.flechas = 0;
    }
    
    public void addFlechas(int flechas){
        this.flechas+=flechas;
    }

    public void usarFlecha(){
        this.flechas--;
    }

    public int getFlechas(){
        return flechas;
    }

    public String toString(){
        return "arco";
    }
}
