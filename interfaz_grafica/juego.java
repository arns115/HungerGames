package interfaz_grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import principal.Facade;
public class juego extends JFrame {
    public int opc;
    private int acceso;
    private JButton pasardias, mostrar_tributos, modificar_tribs;
    public Facade fachada = new Facade();
    private int cont_d = 0;
    private JLabel sucesos;


    public juego(int acceso){
        this.acceso = acceso;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setBounds(0,0,400,400);
        setVisible(false);
        setLocationRelativeTo(null);
        set_components();
        fachada.inicializarJuegos(sucesos);
    }
    private void set_components(){
        sucesos = new JLabel();
        sucesos.setBounds(0,50,200,50);
        add(sucesos);



        pasardias = new JButton("siguiente dia");
        pasardias.setBounds(160,100,150,30);   
        pasardias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                cont_d++;
                fachada.avanzarDia(sucesos);
            }
        });
        add(pasardias);

        mostrar_tributos = new JButton("mostrar tributos vivos");
        mostrar_tributos.setBounds(160,130,150,30);
        mostrar_tributos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                fachada.mostrarTributosVivos(sucesos);
            }
        });
        add(mostrar_tributos);
        if(acceso == 2){
            modificar_tribs = new JButton("modificar el juego");
            modificar_tribs.setBounds(160,160,150,30);
            modificar_tribs.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    fachada.opcionesAdmin();
                }
            });
            add(modificar_tribs);
        }
    }
}
