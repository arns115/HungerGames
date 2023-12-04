package principal;

import distritos.clases_distritos.Distrito;
import participantes.*;
import armas.*;
import armas.Armas_especificas.*;

import java.util.*;


import javax.swing.*;

import java.io.*;

public class Facade {
    Random random;
    List<Distrito> listaDistritos=new ArrayList<Distrito>();
    HashSet <Tributo> TributosVivos=new HashSet<Tributo>();
    List<Arma> armas=new ArrayList<Arma>();

    /**
     * Constructor de la clase fachada
     * Se inicializa la lista con los distritos y se seleccionan las personas que seran tributos
     */
    public Facade(JTextArea l){
        random=new Random();
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
            l.setText(l.getText() + dist.toString() + "\n");
            TributosVivos.add(Cosecha.seleccionarPersona(dist, dist.getNumDistrito(), "hombres"));
            TributosVivos.add(Cosecha.seleccionarPersona(dist, dist.getNumDistrito(), "mujeres"));
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

    public void inicializarJuegos(JTextArea l){
        
        for (Tributo tributo:TributosVivos){
            int rand=random.nextInt(12);
            if(rand>=9){
                l.setText(l.getText() + "El tributo "+tributo.getNombre()+"ha decidido esconderse y no ha encontrado un arma"+"\n");
            }
            else{
                l.setText(l.getText() + "El tributo "+tributo.getNombre()+"ha encontrado un " +armas.get(rand) +"\n");
                tributo.setArma(armas.get(rand));
            }
        }
    }

    /**
     * Metodo para eliminar del set a los tributos que han muerto
     */
    public void eliminarTributosNoVivos(JTextArea l){
    
        for (Tributo tributo:TributosVivos){
            if(!tributo.vivo()){
                l.setText(l.getText() + tributo.getNombre() + " ha muerto");
                TributosVivos.remove(tributo);
            }
        }
    }

    /**
     * Metodo para todo el funcionamiento del juego
     */
    public void avanzarDia(JTextArea l){
        l.setText("");
        for(Tributo tributo:TributosVivos){
            int rand=random.nextInt(4)+1;
            switch(rand){
                case 1:
                    l.setText(l.getText() + tributo.getNombre()+" ha decidido esconderse"+ "\n");
                    break;
                case 2:
                    l.setText(l.getText() + tributo.getNombre()+ " ha decidido atacar a otro tributo" + "\n");
                    int rand2=random.nextInt(TributosVivos.size());
                    int i=0;
                    for(Tributo tributo2:TributosVivos){
                        if(i==rand2){
                            tributo.atacar(tributo2,l);
                        }
                        i++;
                    }
                    break;
                case 3:
                    
                    break;
                case 4:

                    break;
                default:
            }
            tributo.getEstadisticas().setSalud(tributo.getEstadisticas().getSalud()-10);
            eliminarTributosNoVivos(l);
        }
    }

    /**
     * Metodo para imprimir la informacion de los tributos que siguen vivos
     */
    public void mostrarTributosVivos(JTextArea l){
        l.setText("");
        for (Tributo tributo:TributosVivos){
            l.setText(l.getText() + "\n\n" + tributo.toString());
        }
    }

    /**
     * Metodo para que el admin pueda realizar ciertas acciones sobre el juego
     */
    public void opcionesAdmin(){

    }

    public int get_tributos_vivos(){
        return TributosVivos.size();
    }
    public HashSet <Tributo> get_tributos_vivos_hash(){
        return TributosVivos;
    }
    public List<Distrito> get_lista_Distritos(){
        return listaDistritos;
    }

}
