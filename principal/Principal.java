package principal;
import interfaz_grafica.pantalla_principal;


public class Principal {
    public static void main(String [] args){
        pantalla_principal pant_prin = new pantalla_principal();
        InstanciarDistritos.inicializarDistritos();
        pant_prin.setVisible(true);

    }

}
