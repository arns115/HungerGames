package participantes;

public class Estadisticas {
    private int maxSalud;
    private int salud;
    private int maxStamina;
    private int stamina;
    private int inteligencia;
    private int fuerza;
    private int destreza;
    private int velocidad;
    private String sexo;
    /**
     * Constructor de la clase. Inicializa todos los atributos a un valor random entre 0 y 100.
     */
    public Estadisticas(int maxHealth, int maxStamina, double modifFuerza, double modifDestreza, double modifInteligencia, double modifVelocidad,String sexo){
        this.sexo = sexo;
        this.maxSalud=maxHealth;
        this.salud=maxHealth;
        this.maxStamina=maxStamina;
        this.stamina=maxStamina;
        this.inteligencia=(int)(Math.random()*100*modifFuerza);
        this.velocidad=(int)(Math.random()*100*modifDestreza);
        this.destreza=(int)(Math.random()*100*modifInteligencia);
        this.fuerza=(int)(Math.random()*100*modifVelocidad);
    }
    /**
     * getter del sexo(masculino/femenino)
     * @return String
     */
    public String getSexo(){
        return sexo;
    }
    /**
     * Getter de salud maxima
     * @return int
     */
    public int getMaxSalud() {
        return maxSalud;
    }

    /**
     * Getter de salud
     * @return int
     */
    public int getSalud() {
        return salud;
    }

    /**
     * Getter de stamina maxima
     * @return int
     */
    public int getMaxStamina() {
        return maxStamina;
    }

    /**
     * Getter de stamina
     * @return int
     */
    public int getStamina() {
        return stamina;
    }

    /**
     * Getter de destreza
     * @return int
     */
    public int getDestreza() {
        return destreza;
    }

    
    /**
    * Getter de fuerza
     * @return int
     */
    public int getFuerza() {
        return fuerza;
    }

    /**
     * Getter de inteligencia
     * @return int
     */
    public int getInteligencia() {
        return inteligencia;
    }

    /**
     * Getter de velocidad
     * @return int
     */
    public int getVelocidad() {
        return velocidad;
    }

    /**
     * Setter de salud
     * @param salud int
     */
    public void setSalud(int salud) {
        this.salud = salud;
    }

    /**
     * Setter de stamina
     * @param stamina int
     */
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    /**
     * Setter de destreza
     * @param destreza int
     */
    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }


    /**
     * Setter de fuerza
     * @param fuerza int
     */
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    /**
     * Setter de inteligencia
     * @param inteligencia int
     */
    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }


    /**
     * Setter de velocidad 
     * @param velocidad int
     */
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    /**
     * Metodo toString para imprimir las estadisticas de las peronas
     */
    public String toString() {
        return "Salud: "+getSalud() +"/"+ getMaxSalud()+"\n"+
        "Stamina: "+getStamina() +"/"+ getMaxStamina()+"\n"+
        "Fuerza: "+getFuerza()+"\n"+
        "Destreza: "+getDestreza() +"\n"+
        "Inteligencia: "+getInteligencia()+"\n"+
        "Velocidad: "+getVelocidad();
    }
}
