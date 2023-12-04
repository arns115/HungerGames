package principal;

import interfaz_grafica.pantalla_principal;


public class Principal {
    public static void imprimirOpciones(){
        System.out.println("1) Avanzar un dia 2)Mostrar tributos vivos 3) Modificar el juego(opcion para admins)");
    }
    public static void main(String [] args){
        pantalla_principal pant_prin = new pantalla_principal();
        InstanciarDistritos.inicializarDistritos();
    

    }

}
