package distritos.clases_distritos;

import distritos.Distrito;
import participantes.Persona;

public class Distrito9 implements Distrito{
    public void mostrarInformacionDistrito(){
        System.out.println("Distrito 9\n########################");
        System.out.println("El Distrito 9 se especializa en los granos. "+
        "Este distirtio tiene también una gran cantidad de fábricas"+
        "Los habitantes de este distrito son los encargados de producir el pan para el Capitolio y los otros distritos"");
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
