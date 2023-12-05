package interfaz_grafica;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import usuarios.RevisarUsers;




public class pantalla_principal extends JFrame implements ActionListener{
    private ImageIcon img;
    private Font font;
    public JTextField usr, cont;
    private JButton enter;
    private JLabel titulo, resTMP;
    public int verificator = 0;
    private juego jug;
    public pantalla_principal(){
        setTitle("Juegos del hambre");
        setBounds(0,0,640,360);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    
        setVisible(false);
        setLocationRelativeTo(null);
        setLayout(null);
        set_components();
        


        
    }
    private Font cargar_Font(String path){
        Font custom_Font = null;
        try{
            custom_Font = Font.createFont(Font.TRUETYPE_FONT,new File(path)).deriveFont(Font.PLAIN,16);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(custom_Font);

        }catch(IOException | FontFormatException e){
            e.printStackTrace();
            custom_Font = new Font("Arial", Font.PLAIN, 16);
        }
        return custom_Font;
    }
    private void initialize_font(){
        String pathF = "Recursos/DirtyCrown.ttf";
        font = cargar_Font(pathF);
    }
    private void set_components(){
        
        initialize_font();
        
        font.deriveFont(Font.PLAIN, 20);
        titulo = new JLabel("Los juegos del hambre");
        titulo.setBounds(160,0,300,50);
        titulo.setFont(font);
        titulo.setForeground(Color.WHITE);

        add(titulo);

        font.deriveFont(Font.PLAIN, 12);
        resTMP = new JLabel("");
        resTMP.setBounds(160,20,300,30);
        resTMP.setFont(font);
        add(resTMP);
        
        usr = new JTextField("ingrese su usuario");
        usr.setBounds(160,90,200,30);
        usr.setBackground(Color.LIGHT_GRAY);
        usr.setFont(font);
        add(usr);
        
        cont = new JTextField("ingrese la contraseña");
        cont.setBounds(160,120,200,30);
        cont.setBackground(Color.LIGHT_GRAY);
        cont.setFont(font);
        add(cont);
        
        enter = new JButton("entrar");
        enter.setBounds(160,150,150,30);
        enter.setFont(font);
        add(enter);
        
        
        img = new ImageIcon("Recursos/fondo.jpg");
        JLabel etiq_img = new JLabel(img);
        
        etiq_img.setBounds(0,0,640,340);
        add(etiq_img);
        
        enter.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        verificator = RevisarUsers.verificarUsuario(usr.getText(), cont.getText());
        usr.setText("");
        cont.setText("");
        if(verificator == 0){
            resTMP.setText("Usuario o contraseña incorrectos");
        }else{
            jug = new juego(verificator);

            jug.setVisible(true);
            this.setVisible(false);
            dispose();
        }
    }
    
    
}
