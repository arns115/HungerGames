package principal;

import participantes.*;

import java.io.*;

import distritos.clases_distritos.*;

public class Cosecha {
    
    public static Tributo seleccionarPersona(Distrito distrito, Integer num, String HombresOMujeres){
        Tributo tributo=new Tributo("", "", 0, 0, 0, 0, 0, 0, 0, 0,"M");
        try{
            BufferedReader br = new BufferedReader(new FileReader("distritos/personas_distritos/"+num.toString()+"/"+HombresOMujeres+num.toString()+".csv")); 
            String line="";
            String sx = "";
            int maxNum;
            if(HombresOMujeres.equals("hombres")){
                maxNum=distrito.getNumHombres();
                sx = "H";
            }
            else{
                sx = "F";
                maxNum=distrito.getNumMujeres();
            }
            int rand=(int)(Math.random()*maxNum)+1;
            try{
                for (int i=0;i<rand-1;i++){
                    line=br.readLine();
                }
                String []a=line.split(",");
                tributo=new Tributo(a[0], a[1], Integer.valueOf(a[2]), Double.valueOf(a[3]), Integer.valueOf(num), distrito.maxSaludDistrito(), distrito.maxStaminaDistrito()
                ,distrito.modificadorFuerza(), distrito.modificadorDestreza(), distrito.modificadorInteligencia(), distrito.modificadorVelocidad(),sx);

                br.close();

                return tributo;

            } catch(EOFException e1){
                e1.printStackTrace();
                return null;
            }
        }
        catch(IOException e){
            e.printStackTrace();    
            return null;
        }
    }
    

}
