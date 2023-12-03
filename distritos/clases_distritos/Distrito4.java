package distritos.clases_distritos;

import distritos.Distrito;
import participantes.Persona;

public class Distrito4 implements Distrito{
    public void mostrarInformacionDistrito(){
        System.out.println("Distrito 4\n########################");
        System.out.println("El Distrito 4 se espcialiiza en la pesca y la natación. "+
        "Se dice que el Distrito 4 tiene a la gente de más \"decente\" aspecto." +
        " Su pan es salado, pan con forma de pez de color verde debido a la utilización de algas para su producción." );
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
