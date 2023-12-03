package participantes;

public class Tributo extends Persona{
    private int distrito;
    private double estatura;
    private Estadisticas estadisticas;

    /**
     * Constructor principal de clase Tributo
     * @param nombre String
     * @param apellido String
     * @param edad int
     * @param estatura double
     * @param distrito int
     * @param maxHealth int
     * @param maxStamina int
     * @param modifFuerza double
     * @param modifDestreza double
     * @param modifInteligencia double
     * @param modifVelocidad double
     */
    public Tributo(String nombre, String apellido, int edad, double estatura, int distrito, int maxHealth, int maxStamina, double modifFuerza, double modifDestreza, double modifInteligencia, double modifVelocidad){
        super(nombre, apellido, edad);
        this.distrito=distrito;
        this.estatura=estatura;
        this.estadisticas=new Estadisticas(maxHealth, maxStamina, modifFuerza, modifDestreza, modifInteligencia, modifVelocidad);
    }

    /**
     * Constructor de clase tributo sin estatura
     * @param nombre String
     * @param apellido String
     * @param edad int
     * @param maxHealth int
     * @param maxStamina int
     * @param modifFuerza double
     * @param modifDestreza double
     * @param modifInteligencia double
     * @param modifVelocidad double
     */
    public Tributo(String nombre, String apellido, int edad, int distrito, int maxHealth, int maxStamina, double modifFuerza, double modifDestreza, double modifInteligencia, double modifVelocidad){
        super(nombre, apellido, edad);
        this.distrito=distrito;
        this.estadisticas=new Estadisticas(maxHealth, maxStamina, modifFuerza, modifDestreza, modifInteligencia, modifVelocidad);
    }
    
    /**
     * Getter del distrito
     * @return int
     */
    public int getDistrito(){
        return distrito;
    }

    /**
     * Getter de estatura
     * @return double
     */
    public double getEstatura() {
        return estatura;
    }

    /**
     * Getter de estadisticas
     * @return Estadisticas(instancia)
     */
    public Estadisticas getEstadisticas() {
        return estadisticas;
    }

    /**
     * El metodo toString para imprimir toda la informacion del tributo
     * @return String
     */
    public String toString(){
        StringBuilder s=new StringBuilder();
        s.append(super.toString()+"\n");
        s.append("Distrito: "+getDistrito()+"\n");
        if(getEstatura()!=0.0){
            s.append("Estatura: "+ getEstatura()+"\n");
        }
        else{
            s.append("Estatura: No hay informacion disponible\n");
        }
        s.append(getEstadisticas());
        return s.toString();
    }

}
