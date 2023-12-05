package interfaz_grafica;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import distritos.clases_distritos.Distrito;
import principal.Facade;

public class juego extends JFrame implements ActionListener{
    public int opc;
    private int acceso;
    private JButton pasardias, mostrar_tributos, modificar_tribs, mostrar_distritos;
    public Facade fachada;
    private Integer cont_d = 0;
    private JLabel contador_dias, contador_sobrevivientes, clima;
    private JTextArea sucesos;
    private JScrollPane scroll;
    private Font font;

    public juego(int acceso){
        this.acceso = acceso;
        setTitle("JUEGOS DEL HAMBRE");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setBounds(0,0,640,360);
        setVisible(false);
        setLocationRelativeTo(null);
        set_components();
        fachada = new Facade(sucesos);
        fachada.inicializarJuegos(sucesos, clima);
    }
    private void set_components(){
        initialize_font();

        contador_sobrevivientes = new JLabel("tributos vivos: 24");
        contador_sobrevivientes.setBounds(0,10,200,20);
        contador_sobrevivientes.setForeground(Color.WHITE);
        contador_sobrevivientes.setFont(font);
        add(contador_sobrevivientes);

        contador_dias = new JLabel("dias transcurridos: 0");
        contador_dias.setBounds(130,10,200,20);
        contador_dias.setForeground(Color.WHITE);
        contador_dias.setFont(font);
        add(contador_dias);
        
        clima = new JLabel("sin cambios");
        clima.setBounds(450,40,300,20);
        clima.setFont(font);
        clima.setForeground(Color.RED);
        add(clima);


        sucesos = new JTextArea();
        sucesos.setLineWrap(true);
        sucesos.setEditable(false);
        //sucesos.setFont(font);

        scroll = new JScrollPane(sucesos,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(20,50,400,250);
        add(scroll);



        pasardias = new JButton("siguiente dia");
        pasardias.setBounds(450,100,150,30);   
        pasardias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(fachada.get_tributos_vivos()==1){
                    fachada.tipo1.stop1();
                    fachada.tipo2.stop1();
                    fachada.tipo3.stop1();
                    ganador win_p = new ganador(fachada);
                    win_p.setVisible(true);
                    setVisible(false);
                }
                try{
                    fachada.avanzarDia(sucesos);
                }finally{
                    cont_d++;
                    contador_dias.setText("dias transcurridos: " + cont_d.toString());
                    contador_sobrevivientes.setText("tributos vivos: " + fachada.get_tributos_vivos());
                }
            }
        });
        pasardias.setFont(font);
        add(pasardias);

        mostrar_tributos = new JButton("mostrar tributos vivos");
        mostrar_tributos.setBounds(450,130,150,30);
        mostrar_tributos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                fachada.mostrarTributosVivos(sucesos);
            }
        });
        mostrar_tributos.setFont(font);
        add(mostrar_tributos);
        if(acceso == 2){
            modificar_tribs = new JButton("modificar el juego");
            modificar_tribs.setBounds(450,160,150,30);
            modificar_tribs.addActionListener(this);
            modificar_tribs.setFont(font);
            add(modificar_tribs);
        }
        
        mostrar_distritos = new JButton("Mostrar distritos");
        mostrar_distritos.setBounds(450,190,150,30);
        mostrar_distritos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                sucesos.setText("");
                for(Distrito dist: fachada.get_lista_Distritos()){
                    sucesos.setText(sucesos.getText() + "\n" + dist.toString());
                }
            }
        });
        mostrar_distritos.setFont(font);
        add(mostrar_distritos);

        ImageIcon img = new ImageIcon("Recursos/fondo.jpg");
        JLabel etiq_img = new JLabel(img);
        etiq_img.setBounds(0,0,640,340);
        add(etiq_img);
    }
    private Font cargar_Font(String path){
        Font custom_Font = null;
        try{
            custom_Font = Font.createFont(Font.TRUETYPE_FONT,new File(path)).deriveFont(Font.PLAIN,20);
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
    @Override
    public void actionPerformed(ActionEvent e){
        fachada.opcionesAdmin(sucesos, this);
    }
}
