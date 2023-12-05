package principal;

import distritos.clases_distritos.Distrito;
import interfaz_grafica.admin_opc;
import participantes.*;
import armas.*;
import armas.Armas_especificas.*;
import principal.EventosRandom;

import java.util.*;


import javax.swing.*;
//import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Facade {
    Random random;
    List<Distrito> listaDistritos=new ArrayList<Distrito>();
    HashSet <Tributo> TributosVivos=new HashSet<Tributo>();
    List<Arma> armas=new ArrayList<Arma>();
    public EventosRandom tipo1;
    public EventosRandom tipo2;
    public EventosRandom tipo3;
    

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
        catch(EOFException e){

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
                System.out.println("El tributo "+tributo.getNombre()+" ha decidido esconderse y no ha encontrado un arma");
                l.setText(l.getText() + "El tributo "+tributo.getNombre()+" ha decidido esconderse y no ha encontrado un arma"+"\n");
            }
            else{
                System.out.println("El tributo "+tributo.getNombre()+" ha encontrado un " +armas.get(rand));
                l.setText(l.getText() + "El tributo "+tributo.getNombre()+" ha encontrado un " +armas.get(rand) +"\n");
                tributo.setArma(armas.get(rand));
            }
        }
        tipo1=new EventosRandom();
        tipo2=new EventosRandom();
        tipo3=new EventosRandom();
        tipo1.tipo=1;
        tipo2.tipo=2;
        tipo3.tipo=3;
        tipo1.start();
        tipo2.start();
        tipo3.start();
    }

    /**
     * Metodo para eliminar del set a los tributos que han muerto
     */
    public void eliminarTributosNoVivos(JTextArea l){
        List<Tributo> listaNoVivos=new ArrayList<Tributo>();
        for (Tributo tributo:TributosVivos){
            if(!tributo.vivo()){
                listaNoVivos.add(tributo);
            }
        }
        for(Tributo tributo:listaNoVivos){
            TributosVivos.remove(tributo);
            l.setText(l.getText() + tributo.getNombre() + " ha muerto\n");
        }
    }

    /**
     * Metodo para todo el funcionamiento del juego
     */
    public void avanzarDia(JTextArea l){
        l.setText("");
        for(Tributo tributo:TributosVivos){
            if(!tributo.vivo()) continue;
            int rand=random.nextInt(4)+1;
            switch(rand){
                case 1:
                    System.out.println(tributo.getNombre()+" ha decidido esconderse");
                    l.setText(l.getText() + tributo.getNombre()+" se decidido esconder, recuperara un poco de vida y stamina (+50)"+ "\n");
                    // se utiliza el min ya que no se puede sobrepasar salud maxima
                    tributo.getEstadisticas().setSalud(Math.min(tributo.getEstadisticas().getSalud()+50, tributo.getEstadisticas().getMaxSalud()));
                    tributo.getEstadisticas().setStamina(Math.min(tributo.getEstadisticas().getStamina()+50, tributo.getEstadisticas().getMaxStamina()));
                    break;
                case 2:
                    l.setText(l.getText() + tributo.getNombre()+ " ha decidido atacar a otro tributo" + "\n");
                    if(tributo.getArma()!=null){
                        int rand2=random.nextInt(TributosVivos.size());
                        int i=0;
                        for(Tributo tributo2:TributosVivos){
                            if(i==rand2){
                                tributo.atacar(tributo2,l);
                            }
                            i++;
                        }
                    }
                    else{
                        l.setText(l.getText() + tributo.getNombre()+ " no tiene arma, por lo cual no puede atacar" + "\n");
                    }
                    break;
                case 3:
                    System.out.println(tributo.getNombre()+ "  ha encontrado una nueva arma");
                    l.setText(l.getText() + tributo.getNombre()+ "  ha encontrado una nueva arma" + "\n");
                    int rand3=random.nextInt(9);
                    //si tiene un arma se elige al azar si la cambia o no
                    if (tributo.getArma()!=null){
                        if(random.nextInt(2)==1){
                            System.out.println(tributo.getNombre()+ " ha decidido cambiar " +tributo.getArma().toString()+ " por " +armas.get(rand3).toString());
                            tributo.setArma(armas.get(rand3));
                            l.setText(l.getText() + tributo.getNombre()+ " ha decidido cambiar " +tributo.getArma().toString()+ " por " +armas.get(rand3).toString() + "\n");
                            tributo.setArma(armas.get(rand3));
                        }
                        else{
                            System.out.println(tributo.getNombre()+ " ha decidido quedarse con su "+tributo.getArma().toString()+ " en vez de cambiarla por " +
                            armas.get(rand3).toString());
                            l.setText(l.getText() + tributo.getNombre()+ " ha decidido quedarse con su "+tributo.getArma().toString()+ " en vez de cambiarla por " +
                            armas.get(rand3).toString() + "\n");
                        }
                    }
                    else{
                        System.out.println(tributo.getNombre()+" ha equipado "+armas.get(rand3).toString());
                        l.setText(l.getText() + tributo.getNombre()+" ha equipado "+armas.get(rand3).toString());
                        
                        tributo.setArma(armas.get(rand3));
                    }
                    break;
                case 4:
                    System.out.print(tributo.getNombre() +" ha encontrado una pocion de ");
                    l.setText(l.getText() + tributo.getNombre() +" ha encontrado una pocion de ");
                    int rand4=random.nextInt(4)+1;
                    switch (rand4) {
                        case 1:
                            System.out.println("Fuerza(+25 fuerza)");
                            l.setText(l.getText() + "Fuerza(+25 fuerza)" + "\n");
                            tributo.getEstadisticas().setFuerza(tributo.getEstadisticas().getFuerza()+25);
                            break;
                        case 2:
                            System.out.println("Destreza(+25 destreza)");
                            l.setText(l.getText() + "Destreza(+25 destreza)" + "\n");
                            tributo.getEstadisticas().setDestreza(tributo.getEstadisticas().getDestreza()+25);
                            break;
                        case 3:
                            System.out.println("Inteligencia(+25 fuerza)");
                            l.setText(l.getText() + "Inteligencia(+25 fuerza)" + "\n");
                            tributo.getEstadisticas().setInteligencia(tributo.getEstadisticas().getInteligencia()+25);
                            break;
                        case 4:
                            System.out.println("Velocidad(+25 velocidad)"); 
                            l.setText(l.getText() + "Velocidad(+25 velocidad)" + "\n");
                            tributo.getEstadisticas().setVelocidad(tributo.getEstadisticas().getVelocidad()+25);
                            break;
                        default:
                            break;
                    }
                    break;
                default:
            }
            //tributo.getEstadisticas().setSalud(tributo.getEstadisticas().getSalud()-10);
        }
        eliminarTributosNoVivos(l);
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
    public void opcionesAdmin(JTextArea l, JFrame j){
        admin_opc win_admin = new admin_opc(TributosVivos, l, this);
        l.setText("1)Curar vida y stamina de tributos(+15)\n2)Enevenenar arena(-15 vida, -10 stamina)\n3)Aura de estadisticas (+20 a todas las stats)");
        //System.out.println("Que quiere hacer el administrador? ");
        //System.out.println("1)Curar vida y stamina de tributos(+15) 2)Enevenenar arena(-15 vida, -10 stamina) 3)Aura de estadisticas (+20 a todas las stats)");

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
