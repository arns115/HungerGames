package participantes;

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private double estatura;
    private Estadisticas estadisticas;

    /**
     * Constructor de la clase persona
     * @param nombre nombre de la persona
     * @param apellido apellido de la persona
     * @param edad edad de la persona
     * @param estatura estatura de la persona
     * Se inicializan las estadisticas con valores random
     */
    public Persona(String nombre, String apellido, int edad, double estatura){
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
        this.estatura=estatura;
        this.estadisticas=new Estadisticas();
    }

    /**
     * Constructor de la clase persona con menos atributos incializados
     * @param nombre nombre de la persona
     * @param apellido apellido de la persona
     * @param edad edad de la persona
     * Se inicializan las estadisticas con valores random
     */
    public Persona(String nombre, String apellido, int edad){
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
        this.estadisticas=new Estadisticas();
    }

    /**
     * Constructor de la clase persona con menos atributos incializados
     * @param nombre nombre de la persona
     * @param apellido apellido de la persona
     * Se inicializan las estadisticas con valores random
     */
    public Persona(String nombre, String apellido){
        this.nombre=nombre;
        this.apellido=apellido;
        this.estadisticas=new Estadisticas();
    }

    /**
     * Getter de nombre y apellido
     * @return nombre y apellido de la persona
     */
    public String getNombre() {
        return nombre + " " +apellido;
    }

    /**
     * Getter de edad
     * @return edad de la persona
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Getter de estadisticas
     * @return instancia de clase Estadisticas de la persona
     */
    public Estadisticas getEstadisticas() {
        return estadisticas;
    }

    /**
     * Getter de estatura
     * @return estatura de la persona
     */
    public double getEstatura() {
        return estatura;
    }

    /**
     * Sobreescritura del metodo toString para imprimir la informacion de las personas
     */
    public String toString() {
        StringBuilder s=new StringBuilder();
        s.append("Nombre: " + getNombre()+"\n");
        if(getEdad()!=0) s.append("Edad: " +getEdad() +"\n");
        if(getEstatura()!=0.0) s.append("Estatura" + getEstatura());
        s.append("Estadisticas: \n"+ getEstadisticas());
        return s.toString();
    }
}
