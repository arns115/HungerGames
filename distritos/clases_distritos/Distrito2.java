package distritos.clases_distritos;

import distritos.Distrito;

public class Distrito2 implements Distrito{
    public void mostrarInformacionDistrito(){
        System.out.println("Distrito 2\n########################");
        System.out.println("El Distrito 2 se especializa en canteria, pero también fabrica armas y es de donde salen los agentes de la paz."+
        " El Distrito 2 es un gran distrito situado en las Montañas Rocosas, no muy lejos del propio Capitolio. El distrito se compone de "+
        "muchos pequeños pueblos, cada uno basado en una mina. En medio del Distrito 2 hay una montaña central donde se encuentra el comando"+
        " y el control de aparatos para las defensas del Capitolio, ubicada en lo profundo dentro de las Montañas Rocosas. Originalmente el"+
        " Distrito 2 se especializaba exclusivamente en la minería y el corte de piedra, pero después de la guerra de los Días Oscuros, "+
        "también se encargó de la producción de armas. Oficialmente, el Distrito 2 es el encargado de fábricas, pero, se especializan tambien en formar "+
        "agentes de la paz para el ejército del Capitolio. ");
    }

    
    public int maxSaludDistrito(){
        return 200;
    }

    public int maxStaminaDistrito(){
        return 200;
    }

    public double modificadorFuerza() {
        return 1.6;
    }

    public double modificadorInteligencia() {
        return 1.0;
    }

    public double modificadorDestreza() {
        return 1.6;
    }

    public double modificadorVelocidad() {
        return 1.5;
    }


}
