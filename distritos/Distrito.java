package distritos;

import participantes.*;

public interface Distrito {
    /**
     * Se imprime la informacion del distrito que llame al metodo
     */
    public void mostrarInformacionDistrito();
    /**
     * Modificador de fuerza de personas del distrito
     */
    public double modificadorFuerza();
    /**
     * Modificador de destreza de personas del distrito
     */
    public double modificadorDestreza();
    /**
     * Modificador de inteligencia de personas del distrito
     */
    public double modificadorInteligencia();
    /**
     * Modificador de velocidad de personas del distrito
     */
    public double modificadorVelocidad();
    /**
     * Selecciona a una persona al azar de la lista de personas del distrito 
     */
    public Persona seleccionarPersona();
}
