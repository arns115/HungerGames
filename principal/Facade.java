package principal;

import distritos.clases_distritos.Distrito;
import participantes.*;
import java.util.*;
import java.io.*;

public class Facade {
    List<Distrito> listaDistritos=new ArrayList<Distrito>();
    List<Tributo> listaTributos=new ArrayList<Tributo>();

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
            listaTributos.add(Cosecha.seleccionarPersona(dist, dist.getNumDistrito(), "hombre"));
            listaTributos.add(Cosecha.seleccionarPersona(dist, dist.getNumDistrito(), "mujer"));
        }


    }
}
