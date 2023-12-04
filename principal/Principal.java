package principal;

import java.util.Scanner; 
import java.io.*;
import distritos.clases_distritos.Distrito;
import interfaz_grafica.juego;
import interfaz_grafica.pantalla_principal;
import usuarios.*;

public class Principal {
    public static void imprimirOpciones(){
        System.out.println("1) Avanzar un dia 2)Mostrar tributos vivos 3) Modificar el juego(opcion para admins)");
    }
    public static void main(String [] args){
        pantalla_principal pant_prin = new pantalla_principal();
        InstanciarDistritos.inicializarDistritos();
        Scanner sc=new Scanner(System.in);
        String usuario;
        String contrasena;
        int user=0, op=0, contadorDias=1;
        System.out.println("Bienvenido a los juegos del hambre\n");
        System.out.println("Ingrese usuario y contrasena");
        while(user==0){
            /*
            
            usuario=sc.nextLine();
            contrasena=sc.nextLine();
            user=RevisarUsers.verificarUsuario(usuario, contrasena); 
            if(user==0){
                System.out.println("Usuario no existe, vuelva a intentarlo");
            }
            */
            user = pant_prin.verificator;
            System.out.print(user);
        }
        juego jug = new juego(user);
        jug.setVisible(true);
        pant_prin.setVisible(false);
        if(user==1){
            System.out.println("Bienvenido-   Ha ingresado como usuario-");
        }
        else{
            System.out.println("Bienvenido-   Ha ingresado como administrador");
        }
        System.out.println("Que empiecen los juegos!!!");
        Facade facade=new Facade();
        facade.inicializarJuegos();
        while(facade.TributosVivos.size()!=1){
            imprimirOpciones();
            op=sc.nextInt();
            sc.nextLine();
            switch(op){
                case 1:
                    System.out.print("Nos encontramos en el dia "+contadorDias);
                    contadorDias++;
                    facade.avanzarDia();
                    break;
                case 2:
                    facade.mostrarTributosVivos();
                    break;
                case 3:
                    if(user==2){
                        facade.opcionesAdmin();
                    }
                    else{
                        System.out.println("No puedes acceder a esta funcionalidad debido a que no eres admin");
                    }
                    break;
                default:
                    System.out.println("Opcion no disponible");
            }
        }

    }

}
