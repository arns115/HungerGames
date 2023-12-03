package distritos;

public interface Distrito {
    /**
     * Se imprime la informacion del distrito que llame al metodo
     */
    public void mostrarInformacionDistrito();

    /**
     * Devuelve numero de hombres en el distrito
     * @return int
     */
    public int getNumHombres();

    /**
     * Devuelve numero de mujeres en el distrito
     * @return int
     */
    public int getNumMujeres();


    /**
     * Maxima salud del distrito 
     * @return int
     */
    public int maxSaludDistrito();

    /**
     * Maxima stamina del distrito 
     * @return int
     */
    public int maxStaminaDistrito();

    /**
     * Modificador de fuerza de personas del distrito\
     * @return double
     */
    public double modificadorFuerza();

    /**
     * Modificador de destreza de personas del distrito
     * @return double
     */
    public double modificadorDestreza();

    /**
     * Modificador de inteligencia de personas del distrito
     * @return double
     */
    public double modificadorInteligencia();

    /**
     * Modificador de velocidad de personas del distrito
     * @return double
     */
    public double modificadorVelocidad();


}
