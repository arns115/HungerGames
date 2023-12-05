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
            archivo = new File ("usuarios/users.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null){
                String[] datos=linea.split(",");
                datos[1].strip();
                if(datos[0].equals(usuario) && datos[1].equals(contrasena)){
                    System.out.println("Bienvenido "+usuario);
                    return 1;
                }
            }
            fr.close();
            archivo = new File ("usuarios/admins.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            while((linea=br.readLine())!=null){
                String[] datos=linea.split(",");
                datos[1].strip();
                if(datos[0].equals(usuario) && datos[1].equals(contrasena)){
                    System.out.println("Bienvenido "+usuario);
                    return 2;
                }
            }
            System.out.println("Usuario o contrasena incorrectos");
            return 0;
        }
        catch(Exception e){
            
        }finally{
            try{                    
                if( null != fr ){   
                    fr.close();     
                }                  
            }catch (Exception e2){ 

            }
        }
        return 0;
    }
}
