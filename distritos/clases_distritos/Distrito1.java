package distritos.clases_distritos;

import distritos.Distrito;

public class Distrito1 implements Distrito{
    public void mostrarInformacionDistrito(){
        System.out.println("Distrito 1\n########################");
        System.out.println("El Distrito 1 se especializa en productos de lujo (artículos de lujo como joyas)."+
        "Parece que toda la gente de Distrito 1 lleva el nombre de un atributo de un artículo de lujo. Los niños allí"+
        " están orgullosos de competir en los Juegos, y se encuentran entre el grupo de los tributos apodados 'profesionales'"+
        " que se entrenan para los juegos (ilegalmente) desde una edad temprana y, después se ofrecen voluntariamente para competir."+
        " Una vez que comienzan los juegos, los tributos de los profesionales (incluyendo los Distritos 1, 2, 4, y otros distritos" +
        "de vez en cuando) tienden a unirse hasta que se ven obligados a luchar entre ellos, y son un número desproporcionado de "+
        "tributos profesionales en los juegos del hambre. ");
    }

    public int maxSaludDistrito(){
        return 150;
    }

    public int maxStaminaDistrito(){
        return 150;
    }

    public double modificadorFuerza() {
        return 1.5;
    }

    public double modificadorInteligencia() {
        return 1.5;
    }

    public double modificadorDestreza() {
        return 1.5;
    }

    public double modificadorVelocidad() {
        return 1.5;
    }

}
