package distritos.clases_distritos;

import distritos.Distrito;
import participantes.Persona;

public class Distrito11 implements Distrito{
    public void mostrarInformacionDistrito(){
        System.out.println("Distrito 11\n########################");
        System.out.println("El Distrito 11 se especializa en la agricultura. "+
        "El Distrito 11 se especializa en la agricultura. Se encuentra en algún lugar del sur y es muy grande."+
        "Las personas se alojan en chozas pequeñas y hay una represión dura por parte de los agentes de la paz."+
        "Los rasgos comunes son la piel oscura y ojos marrones.");
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
