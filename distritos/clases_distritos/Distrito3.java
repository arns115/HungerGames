package distritos.clases_distritos;

import distritos.Distrito;

public class Distrito3 implements Distrito{
    public void mostrarInformacionDistrito(){
        System.out.println("Distrito 3\n########################");
        System.out.println("El Distrito 3 se especializa en la tecnología y la electrónica. "+
        "La mayoría de sus habitantes trabajan en las fábricas y son muy hábiles con la ingeniería."+
        " Algunas personas piensan que el Distrito 3 es débil, pero su inteligencia proporciona muchos beneficios."+
        " Sus tributos tienden a usar esto para su ventaja.");
    }

    public int maxSaludDistrito(){
        return 100;
    }

    public int maxStaminaDistrito(){
        return 90;
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


}
