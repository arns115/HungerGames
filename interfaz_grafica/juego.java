package interfaz_grafica;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import distritos.clases_distritos.Distrito;
import principal.Facade;
public class juego extends JFrame {
    public int opc;
    private int acceso;
    private JButton pasardias, mostrar_tributos, modificar_tribs, mostrar_distritos;
    public Facade fachada;
    private Integer cont_d = 0;
    private JLabel contador_dias, contador_sobrevivientes;
    private JTextArea sucesos;
    private JScrollPane scroll;
    

    public juego(int acceso){
        this.acceso = acceso;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setBounds(0,0,500,600);
        setVisible(false);
        setLocationRelativeTo(null);
        set_components();
        fachada = new Facade(sucesos);
        fachada.inicializarJuegos(sucesos);
    }
    private void set_components(){
        contador_sobrevivientes = new JLabel("tributos vivos: 24");
        contador_sobrevivientes.setBounds(0,10,200,20);
        add(contador_sobrevivientes);

        contador_dias = new JLabel("dias transcurridos: 0");
        contador_dias.setBounds(100,10,200,20);
        add(contador_dias);


        sucesos = new JTextArea();
        sucesos.setLineWrap(true);
        sucesos.setEditable(false);

        scroll = new JScrollPane(sucesos,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(20,50,400,250);
        add(scroll);



        pasardias = new JButton("siguiente dia");
        pasardias.setBounds(160,300,150,30);   
        pasardias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(fachada.get_tributos_vivos()==1){
                    ganador win_p = new ganador(fachada);
                    win_p.setVisible(true);
                    setVisible(false);
                }

                cont_d++;
                fachada.avanzarDia(sucesos);
                contador_dias.setText("dias transcurridos: " + cont_d.toString());
                contador_sobrevivientes.setText("tributos vivos: " + fachada.get_tributos_vivos());
            }
        });
        add(pasardias);

        mostrar_tributos = new JButton("mostrar tributos vivos");
        mostrar_tributos.setBounds(160,330,150,30);
        mostrar_tributos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                fachada.mostrarTributosVivos(sucesos);
            }
        });
        add(mostrar_tributos);
        if(acceso == 2){
            modificar_tribs = new JButton("modificar el juego");
            modificar_tribs.setBounds(160,360,150,30);
            modificar_tribs.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    fachada.opcionesAdmin();
                }
            });
            add(modificar_tribs);
        }

        mostrar_distritos = new JButton("Mostrar distritos");
        mostrar_distritos.setBounds(160,390,150,30);
        mostrar_distritos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                sucesos.setText("");
                for(Distrito dist: fachada.get_lista_Distritos()){
                    sucesos.setText(sucesos.getText() + "\n" + dist.toString());
                }
            }
        });
        add(mostrar_distritos);
    }
}
