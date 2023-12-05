package principal;

import java.io.*;
import distritos.clases_distritos.*;

public class InstanciarDistritos {
    public static void inicializarDistritos(){
        try{
            ObjectOutputStream f = new ObjectOutputStream(new FileOutputStream("objetosDistritos.sav"));

            Distrito distrito1=new Distrito(1,"Distrito 1\n########################\n"+
            "El Distrito 1 se especializa en productos de lujo (artículos de lujo como joyas)."+
            "Parece que toda la gente de Distrito 1 lleva el nombre de un atributo de un artículo de lujo. Los niños allí"+
            " están orgullosos de competir en los Juegos, y se encuentran entre el grupo de los tributos apodados 'profesionales'"+
            " que se entrenan para los juegos (ilegalmente) desde una edad temprana y, después se ofrecen voluntariamente para competir."+
            " Una vez que comienzan los juegos, los tributos de los profesionales (incluyendo los Distritos 1, 2, 4, y otros distritos" +
            "de vez en cuando) tienden a unirse hasta que se ven obligados a luchar entre ellos, y son un número desproporcionado de "+
            "tributos profesionales en los juegos del hambre. ", 150, 150, 
            1.5, 1.5, 1.5, 1.5, 500, 500);

            Distrito distrito2=new Distrito(2,"Distrito 2\n########################\n"+
            "El Distrito 2 se especializa en canteria, pero también fabrica armas y es de donde salen los agentes de la paz."+
            " El Distrito 2 es un gran distrito situado en las Montañas Rocosas, no muy lejos del propio Capitolio. El distrito se compone de "+
            "muchos pequeños pueblos, cada uno basado en una mina. En medio del Distrito 2 hay una montaña central donde se encuentra el comando"+
            " y el control de aparatos para las defensas del Capitolio, ubicada en lo profundo dentro de las Montañas Rocosas. Originalmente el"+
            " Distrito 2 se especializaba exclusivamente en la minería y el corte de piedra, pero después de la guerra de los Días Oscuros, "+
            "también se encargó de la producción de armas. Oficialmente, el Distrito 2 es el encargado de fábricas, pero, se especializan tambien en formar "+
            "agentes de la paz para el ejército del Capitolio." , 150, 200, 
            1.8, 1.3, 0.5, 1.1, 600, 246);

            Distrito distrito3=new Distrito(3,"Distrito 3\n########################\n"+
            "El Distrito 3 se especializa en la tecnología y la electrónica. "+
            "La mayoría de sus habitantes trabajan en las fábricas y son muy hábiles con la ingeniería."+
            " Algunas personas piensan que el Distrito 3 es débil, pero su inteligencia proporciona muchos beneficios."+
            " Sus tributos tienden a usar esto para su ventaja." , 100, 90, 
            0.75, 0.8, 2.0, 0.9, 320, 743);

            Distrito distrito4=new Distrito(4,"Distrito 4\n########################\n"+
            "El Distrito 4 se espcialiiza en la pesca y la natación. "+
            "Se dice que el Distrito 4 tiene a la gente de más \"decente\" aspecto." +
            " Su pan es salado, pan con forma de pez de color verde debido a la utilización de algas para su producción." , 110, 120, 
            1.0, 1.4, 1.2, 1.4, 675, 500);

            Distrito distrito5=new Distrito(5,"Distrito 5\n########################\n"+
            "El Distrito 5 se especializa en la energía. "+
            "Sus habitantes trabajan en la central eléctrica y en la central de energía solar"+
            "Cuando hay problemas eléctricos en el Capitolio, los habitantes del Distrito 5 son los encargados de solucionarlos" , 95, 95, 
            0.9, 0.85, 1.5, 1.0, 525, 324);

            Distrito distrito6=new Distrito(6,"Distrito 6\n########################\n"+
            "El Distrito 6 se especializa en el transporte. "+
            "Los habitantes de este distrito son los encargados de transportar a los ciudadanos del Capitolio y de los otros distritos"+
            "Aqui se fabrican los trenes y los vehículos de transporte" , 110, 85, 
            1.15, 0.95, 1.0, 1.0, 550, 633);

            Distrito distrito7=new Distrito(7,"Distrito 7\n########################\n"+
            "El Distrito 7 se especializa en la madera y el papel. "+
            "Una gran parte de los bosques del Distrito 7 son de pino"+
            "Ademas de talar los arboles, los habitantes de este distrito se encargan de la fabricación de muebles y papel" , 125, 125, 
            1.3, 1.1, 1.1, 1.0, 490, 490);

            Distrito distrito8=new Distrito(8,"Distrito 8\n########################\n"+
            "El Distrito 8 se especializa en textiles. "+
            "Es la principal fuente de ropa para el Capitolio y los otros distritos."+
            "En la actualidad, el Distrito 8 es el más rebelde de todos los distritos" , 110, 120, 
            1.2, 1.3, 1.3, 1.1, 535, 520);

            Distrito distrito9=new Distrito(9,"Distrito 9\n########################\n"+
            "El Distrito 9 se especializa en los granos. "+
            "Este distirtio tiene también una gran cantidad de fábricas"+
            "Los habitantes de este distrito son los encargados de producir el pan para el Capitolio y los otros distritos" , 75, 90, 
            0.6, 1.6, 1.0, 1.3, 620, 378);

            Distrito distrito10=new Distrito(10,"Distrito 10\n########################\n"+
            "Es uno de los distritos pobres de Panem. Su industria principal es la ganadería y son quienes proveen de carne al Capitolio."+
            " Sus tributos no suelen aguantar mucho tiempo en la arena y no tienen muchos vencedores de los Juegos."  , 80, 110, 
            0.7, 0.8, 0.9, 0.85, 815, 625);

            Distrito distrito11=new Distrito(11,"Distrito 11\n########################\n"+
            "El Distrito 11 se especializa en la agricultura. Se encuentra en algún lugar del sur y es muy grande."+
            "Las personas se alojan en chozas pequeñas y hay una represión dura por parte de los agentes de la paz."+
            "Los rasgos comunes son la piel oscura y ojos marrones."  , 65, 75, 
                0.65, 0.65, 0.8, 1.0, 695, 428);

            Distrito distrito12=new Distrito(12,"Distrito 12\n########################\n"+
            "El Distrito 12 se especializa en la minería. "+
            "El Distrito 12 es muy pobre y el hambre es un problema importante para los ciudadanos."+
            "Debido a la falta de alimentos las autoridades locales del Capitolio, el alcalde y los agentes de la paz a menudo "+
            "infringen las leyes de Panem, que son muy estrictas. La valla que rodea el distrito y evita el acceso a los bosques"+
            " y se supone que está electrificada no está electrificada, dando paso a la caza ilegal, pero no penada"  , 80, 150, 
                1.1, 1.5, 1.0, 1.5, 1000, 1000);

            f.writeObject(distrito1);

            f.writeObject(distrito2);

            f.writeObject(distrito3);

            f.writeObject(distrito4);

            f.writeObject(distrito5);

            f.writeObject(distrito6);

            f.writeObject(distrito7);

            f.writeObject(distrito8);

            f.writeObject(distrito9);

            f.writeObject(distrito10);

            f.writeObject(distrito11);

            f.writeObject(distrito12);

            f.close();
        }
        catch (IOException e){
            
        }
    }
}
