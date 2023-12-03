package distritos.clases_distritos;

import distritos.Distrito;
import participantes.Persona;

public class Distrito12 implements Distrito{
    public void mostrarInformacionDistrito(){
        System.out.println("Distrito 12\n########################");
        System.out.println("El Distrito 12 se especializa en la minería. "+
        "El Distrito 12 es muy pobre y el hambre es un problema importante para los ciudadanos."+
        "Debido a la falta de alimentos las autoridades locales del Capitolio, el alcalde y los agentes de la paz a menudo infringen las leyes de Panem, que son muy estrictas. "+
        "La valla que rodea el distrito y evita el acceso a los bosques y se supone que está electrificada no está electrificada, dando paso a la caza ilegal, pero no penada");
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
