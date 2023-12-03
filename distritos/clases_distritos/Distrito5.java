package distritos.clases_distritos;

import distritos.Distrito;
import participantes.Persona;

public class Distrito5 implements Distrito{
    public void mostrarInformacionDistrito(){
        System.out.println("Distrito 5\n########################");
        System.out.println("El Distrito 5 se especializa en la energía. "+
        "Sus habitantes trabajan en la central eléctrica y en la central de energía solar"+
        "Cuando hay problemas eléctricos en el Capitolio, los habitantes del Distrito 5 son los encargados de solucionarlos");
    }

    public double modificadorFuerza() {
        return 0.9;
    }

    public double modificadorInteligencia() {
        return 2.0;
    }

    public double modificadorDestreza() {
        return 0.9;
    }

    public double modificadorVelocidad() {
        return 1.1;
    }

    public Persona seleccionarPersona(){
        
    }
}
