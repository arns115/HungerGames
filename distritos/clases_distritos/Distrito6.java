package distritos.clases_distritos;

import distritos.Distrito;
import participantes.Persona;

public class Distrito6 implements Distrito{
    public void mostrarInformacionDistrito(){
        System.out.println("Distrito 6\n########################");
        System.out.println("El Distrito 6 se especializa en el transporte. "+
        "Los habitantes de este distrito son los encargados de transportar a los ciudadanos del Capitolio y de los otros distritos"+
        "Aqui se fabrican los trenes y los vehículos de transporte");
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
