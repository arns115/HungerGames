package participantes;

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    /**
     * Constructor de la clase persona
     * @param nombre String
     * @param apellido String
     * @param edad int
     */
    public Persona(String nombre, String apellido, int edad){
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
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
     * @return edad de persona
     */
    public int getEdad() {
        return edad;
    }
    /**
     * Sobreescritura del metodo toString para imprimir la informacion de las personas
     */
    public String toString() {
        return "Nombre: " + getNombre()+"\nEdad: " +getEdad();
    }
}
