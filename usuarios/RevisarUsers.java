package usuarios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class RevisarUsers {
    public static int verificarUsuario(String usuario, String contrasena){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File ("users.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null){
                String[] datos=linea.split(",");
                if(datos[0].equals(usuario) && datos[1].equals(contrasena)){
                    System.out.println("Bienvenido "+usuario);
                    return 1;
                }
            }
            fr.close();
            archivo = new File ("admins.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            while((linea=br.readLine())!=null){
                String[] datos=linea.split(",");
                if(datos[0].equals(usuario) && datos[1].equals(contrasena)){
                    System.out.println("Bienvenido "+usuario);
                    return 2;
                }
            }
            System.out.println("Usuario o contrasena incorrectos");
            return 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            try{                    
                if( null != fr ){   
                    fr.close();     
                }                  
            }catch (Exception e2){ 
                e2.printStackTrace();
            }
        }
        return 0;
    }
}
