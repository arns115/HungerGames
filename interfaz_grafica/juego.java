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
    private Integer cont_d = 0;
    private JLabel contador_dias;
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
        fachada.inicializarJuegos(sucesos);
    }
    private void set_components(){
        contador_dias = new JLabel("dias transcurridos: 0");
        contador_dias.setBounds(160,10,100,20);
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
                cont_d++;
                fachada.avanzarDia(sucesos);
                contador_dias.setText("dias transcurridos: " + cont_d.toString());
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
    }
}
