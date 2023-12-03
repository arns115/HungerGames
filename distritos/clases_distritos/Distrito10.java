package distritos.clases_distritos;

import distritos.Distrito;
import participantes.Persona;

public class Distrito10 implements Distrito{
    public void mostrarInformacionDistrito(){
        System.out.println("Distrito 10\n########################");
        System.out.println("El Distrito 10 se especializa en el ganado. "+
        "La mayoría de sus habitantes trabajan en las fábricas y son muy hábiles con la ingeniería."+
        " Algunas personas piensan que el Distrito 3 es débil, pero su inteligencia proporciona muchos beneficios."+
        " Sus tributos tienden a usar esto para su ventaja.");
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
