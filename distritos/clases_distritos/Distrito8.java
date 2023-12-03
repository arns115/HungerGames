package distritos.clases_distritos;

import distritos.Distrito;
import participantes.Persona;

public class Distrito8 implements Distrito{
    public void mostrarInformacionDistrito(){
        System.out.println("Distrito 8\n########################");
        System.out.println("El Distrito 8 se especializa en textiles. "+
        "Es la principal fuente de ropa para el Capitolio y los otros distritos."+
        "En la actualidad, el Distrito 8 es el más rebelde de todos los distritos");
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
