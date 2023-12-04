package principal;

import distritos.clases_distritos.Distrito;
import participantes.*;
import armas.*;
import armas.Armas_especificas.*;

import java.util.*;
import java.io.*;

public class Facade {
    List<Distrito> listaDistritos=new ArrayList<Distrito>();
    HashSet <Tributo> TributosVivos=new HashSet<Tributo>();
    List<Arma> armas=new ArrayList<Arma>();

    /**
     * Constructor de la clase fachada
     * Se inicializa la lista con los distritos y se seleccionan las personas que seran tributos
     */
    public Facade(){
        try{
            ObjectInputStream f=new ObjectInputStream(new FileInputStream("objetosDistritos.sav"));
            while(true){
                Distrito distrito=(Distrito)f.readObject();
                if(distrito==null){
                    break;
                }
                else{
                    listaDistritos.add(distrito);
                }
            }
            f.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        //Imprime la informacion de los distritos junto a las personas que se han seleccionado
        for (Distrito dist: listaDistritos){
            System.out.println(dist.toString());
            TributosVivos.add(Cosecha.seleccionarPersona(dist, dist.getNumDistrito(), "hombre"));
            TributosVivos.add(Cosecha.seleccionarPersona(dist, dist.getNumDistrito(), "mujer"));
        }

        //Se anaden las armas a la lista de armas
        armas.add(new arco());
        armas.add(new ballesta());
        armas.add(new cuchillo_lanzable());
        armas.add(new cuchillo());
        armas.add(new espada());
        armas.add(new estrellas());
        armas.add(new hacha());
        armas.add(new resortera());
        armas.add(new tridente());
    }

    public void inicializarJuegos(){
        for (Tributo tributo:TributosVivos){
            int rand=((int)Math.random()*100)%12;
            if(rand>=9){
                System.out.println("El tributo "+tributo.getNombre()+"ha decidido esconderse y no ha encontrado un arma");
            }
            else{
                System.out.println("El tributo "+tributo.getNombre()+"ha encontrado un " +armas.get(rand));
                tributo.setArma(armas.get(rand));
            }
        }
    }

    /**
     * Metodo para todo el funcionamiento del juego
     */
    public void avanzarDia(){
        
    }

    /**
     * Metodo para imprimir la informacion de los tributos que siguen vivos
     */
    public void mostrarTributosVivos(){
        
        for (Tributo tributo:TributosVivos){
            System.out.println(tributo);
        }
    }

    /**
     * Metodo para que el admin pueda realizar ciertas acciones sobre el juego
     */
    public void opcionesAdmin(){

    }
}
