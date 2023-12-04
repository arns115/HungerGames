package participantes;

import armas.*;

public class Tributo extends Persona{
    private int distrito;
    private double estatura;
    private Estadisticas estadisticas;
    private Arma arma;

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
     * Getter de arma
     * @return Arma(instancia)
     */
    public Arma getArma(){
        return arma;
    }

    /**
     * Setter de arma
     * @param Arma
     */
    public void setArma(Arma arma) {
        this.arma = arma;
    }

    /**
     * Metodo para conocer si un tributo en especifico esta vivo
     * @return boolean
     */
    public boolean vivo(){
        return (getEstadisticas().getSalud()>0);
    }


    /**
     * Metodo para conocer si cierto tributo con sus estadisticas actuales puede usar el arma que tiene
     * @return boolean
     */
    public boolean poderUsarArma(){
        Estadisticas stats=getEstadisticas();
        return (stats.getFuerza()>=arma.getRequerimientoFuerza() && stats.getDestreza()>=arma.getRequerimientoDestreza() 
        && stats.getInteligencia()>=arma.getRequerimientoInteligencia() && stats.getVelocidad()>=arma.getRequerimientoVelocidad()
        && stats.getStamina()>=arma.getRequerimientoStamina());
    }

    /**
     * Metodo para que un tributo ataque a otro tributo
     * @param tributoAAtacar Tributo(instancia de otro tributo)
     */
    public boolean atacar(Tributo tributoAAtacar){
        if (poderUsarArma()){
            tributoAAtacar.getEstadisticas().setSalud(tributoAAtacar.getEstadisticas().getSalud()-arma.hacerDano(estadisticas.getFuerza()
            , estadisticas.getDestreza(), estadisticas.getInteligencia(), estadisticas.getVelocidad()));

            estadisticas.setStamina(estadisticas.getStamina()-arma.getRequerimientoStamina());
            return true;
        }
        else{
            System.out.println(getNombre() +" ha intentado atacar a" +tributoAAtacar.getNombre()+ " pero no tiene las suficientes estadisticas para hacerlo con el arma actual");
            return false;
        
        }
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
        if(getArma()!=null){
            s.append("Arma: "+ getArma()+"\n");
        }
        return s.toString();
    }

}
