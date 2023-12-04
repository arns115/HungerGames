package principal;

import java.util.Scanner; 
import java.io.*;
import distritos.clases_distritos.Distrito;

public class Principal {
    public static void main(String [] args){
        InstanciarDistritos.inicializarDistritos();
        Scanner sc=new Scanner(System.in);
        String usuario;
        String contrasena;
        System.out.println("Bienvenido a los juegos del hambre\n");
        System.out.println("Ingrese usuario y contrasena");
        usuario=sc.nextLine();
        contrasena=sc.nextLine();
        int user=verificarUsuario(usuario, contrasena); 
        System.out.println(user);

    }

    private static int verificarUsuario(String usuario, String contrasena){
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
