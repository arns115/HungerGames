package armas;

public class Arma {
    private int dano;
    private int requerimientoFuerza;
    private int requerimientoDestreza;
    private int requerimientoInteligencia;
    private int requerimientoVelocidad;
    private int requerimientoStamina;

    /**
     * Constructor de la clase Arma
     * @param dano int
     * @param requerimientoFuerza int
     * @param requerimientoDestreza int
     * @param requerimientoInteligencia int
     * @param requerimientoVelocidad int
     * @param requerimientoStamina int
     */
    public Arma(int dano, int requerimientoFuerza, int requerimientoDestreza, int requerimientoInteligencia, int requerimientoVelocidad, int requerimientoStamina){
        this.dano=dano;
        this.requerimientoFuerza=requerimientoFuerza;
        this.requerimientoDestreza=requerimientoDestreza;
        this.requerimientoInteligencia=requerimientoInteligencia;
        this.requerimientoVelocidad=requerimientoVelocidad;
        this.requerimientoStamina=requerimientoStamina;
    }


    /**
     * Getter del dano del arma
     * @return int
     */
    public int getDano() {
        return dano;
    }

    /**
     * Getter del requerimiento de fuerza para poder usar el arma
     * @return int
     */
    public int getRequerimientoFuerza() {
        return requerimientoFuerza;
    }
    
    /**
     * Getter del requerimiento de destreza para poder usar el arma
     * @return int
     */
    public int getRequerimientoDestreza() {
        return requerimientoDestreza;
    }

    /**
     * Getter del requerimiento de inteligencia para poder usar el arma
     * @return int
     */
    public int getRequerimientoInteligencia() {
        return requerimientoInteligencia;
    }

    /**
     * Getter del requerimiento de velocidad para poder usar el arma
     * @return int
     */
    public int getRequerimientoVelocidad() {
        return requerimientoVelocidad;
    }

    /**
     * Getter del requerimiento de stamina para poder usar el arma
     * @return int
     */
    public int getRequerimientoStamina() {
        return requerimientoStamina;
    }

    /**
     * Metodo para saber cuanto dano hacer una arma con las estadisticas de la persona especifica
     * @param fuerza int
     * @param destreza int
     * @param inteligencia int
     * @param velocidad int
     * @return int(dano total)
     */
    public int hacerDano(int fuerza, int destreza, int inteligencia, int velocidad){
        int danoTotal=getDano();
        
        return danoTotal;
    }

    /**
     * Metodo para imprimir el nombre del arma
     */
    public String toString(){
        return (Arma.class.getName());
    }
}
