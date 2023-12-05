package armas.Armas_especificas;

import armas.Arma;

public class ballesta extends Arma{
    private int flechas;

    public ballesta() {
        super(70,10,40,20,40,10);
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
        return "ballesta";
    }
}
