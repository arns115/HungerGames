package distritos.clases_distritos;

import distritos.Distrito;
import participantes.Persona;

public class Distrito7 implements Distrito{
    public void mostrarInformacionDistrito(){
        System.out.println("Distrito 7\n########################");
        System.out.println("El Distrito 7 se especializa en la madera y el papel. "+
        "Una gran parte de los bosques del Distrito 7 son de pino"+
        "Ademas de talar los arboles, los habitantes de este distrito se encargan de la fabricación de muebles y papel");
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
