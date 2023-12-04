package principal;

import distritos.clases_distritos.Distrito;
import participantes.*;
import armas.*;
import armas.Armas_especificas.*;

import java.util.*;

import javax.swing.JLabel;

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
    public Facade(){
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
            System.out.println(dist.toString());
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

    public void inicializarJuegos(JLabel l){
        for (Tributo tributo:TributosVivos){
            int rand=random.nextInt(12);
            if(rand>=9){
                System.out.println("El tributo "+tributo.getNombre()+"ha decidido esconderse y no ha encontrado un arma");
                l.setText("El tributo "+tributo.getNombre()+"ha decidido esconderse y no ha encontrado un arma");
            }
            else{
                System.out.println("El tributo "+tributo.getNombre()+"ha encontrado un " +armas.get(rand));
                l.setText("El tributo "+tributo.getNombre()+"ha encontrado un " +armas.get(rand));
                tributo.setArma(armas.get(rand));
            }
        }
    }

    /**
     * Metodo para eliminar del set a los tributos que han muerto
     */
    public void eliminarTributosNoVivos(){
        for (Tributo tributo:TributosVivos){
            if(!tributo.vivo()){
                System.out.println(tributo.getNombre() +" ha muerto");
                TributosVivos.remove(tributo);
            }
        }
    }

    /**
     * Metodo para todo el funcionamiento del juego
     */
    public void avanzarDia(JLabel l){
        for(Tributo tributo:TributosVivos){
            int rand=random.nextInt(4)+1;
            switch(rand){
                case 1:
                    l.setText(tributo.getNombre()+" ha decidido esconderese");
                    System.out.println(tributo.getNombre()+" ha decidido esconderese");
                    break;
                case 2:
                    l.setText(tributo.getNombre()+ " ha decidido atacar a otro tributo");
                    System.out.println(tributo.getNombre()+ " ha decidido atacar a otro tributo");
                    int rand2=random.nextInt(TributosVivos.size());
                    int i=0;
                    for(Tributo tributo2:TributosVivos){
                        if(i==rand2){
                            tributo.atacar(tributo2);
                        }
                        i++;
                    }
                    break;
                case 3:
                    
                    break;
                case 4:

                    break;
                default:
                    System.out.println("Ha aparecido un error");
            }
            eliminarTributosNoVivos();
        }
    }

    /**
     * Metodo para imprimir la informacion de los tributos que siguen vivos
     */
    public void mostrarTributosVivos(JLabel l){
        
        for (Tributo tributo:TributosVivos){
            System.out.println(tributo);
            l.setText(tributo.toString());
        }
    }

    /**
     * Metodo para que el admin pueda realizar ciertas acciones sobre el juego
     */
    public void opcionesAdmin(){

    }
}
