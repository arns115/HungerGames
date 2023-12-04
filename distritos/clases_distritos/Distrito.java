package distritos.clases_distritos;

import java.io.Serializable;

import distritos.DistritoInterfaz;

public class Distrito implements DistritoInterfaz, Serializable{
    private int numDistrito;
    private String info;
    private int maxSaludDistrito;
    private int maxStaminaDistrito;
    private double modificadorFuerza;
    private double modificadorDestreza;
    private double modificadorInteligencia;
    private double modificadorVelocidad;
    private int numHombres;
    private int numMujeres;

    /**
     * Constructor de la clase Distrito
     * @param numDistrito int
     * @param info String
     * @param maxSaludDistrito int
     * @param maxStaminaDistrito int
     * @param modificadorFuerza double
     * @param modificadorDestreza double
     * @param modificadorInteligencia double
     * @param modificadorVelocidad double
     * @param numHombres int
     * @param numMujeres int
     */
    public Distrito(int numDistrito, String info, int maxSaludDistrito, int maxStaminaDistrito, double modificadorFuerza, double modificadorDestreza, double modificadorInteligencia, double modificadorVelocidad, int numHombres, int numMujeres){
        this.numDistrito=numDistrito;
        this.info=info;
        this.maxSaludDistrito=maxSaludDistrito;
        this.maxStaminaDistrito=maxStaminaDistrito;
        this.modificadorFuerza=modificadorFuerza;
        this.modificadorDestreza=modificadorDestreza;
        this.modificadorInteligencia=modificadorInteligencia;
        this.modificadorVelocidad=modificadorVelocidad;
        this.numHombres=numHombres;
        this.numMujeres=numMujeres;
    }

    public int getNumDistrito() {
        return numDistrito;
    }

    @Override
    public String mostrarInformacionDistrito() {
        return info;
    }

    public int maxSaludDistrito() {
        return maxSaludDistrito;
    }

    public int maxStaminaDistrito() {
        return maxStaminaDistrito;
    }

    public double modificadorFuerza() {
        return modificadorFuerza;
    }

    public double modificadorDestreza() {
        return modificadorDestreza;
    }

    public double modificadorInteligencia() {
        return modificadorInteligencia;
    }

    public double modificadorVelocidad() {
        return modificadorVelocidad;
    }

    public int getNumHombres() {
        return numHombres;
    }

    public int getNumMujeres() {
        return numMujeres;
    }
    
    /**
     * Metodo toString de la clase para imprimir la informacion de los distritos.
     */
    public String toString(){
        return mostrarInformacionDistrito()+
        "\nSalud maxima: " +maxSaludDistrito()+
        "\nStamina maxima: "+maxStaminaDistrito()+
        "\nModificadorFuerza: "+modificadorFuerza()+
        "\nModificadorDestreza: "+modificadorDestreza()+
        "\nModificadorInteligencia: "+modificadorInteligencia()+
        "\nModificadorVelocidad: "+modificadorVelocidad()+
        "\nNumero de hombres: "+getNumHombres()+
        "\nNumero de mujeres: " +getNumMujeres();
    }

}
