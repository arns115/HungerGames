package interfaz_grafica;

import java.awt.event.*;
import java.util.HashSet;

import javax.swing.*;

import participantes.Tributo;
import principal.Facade;

public class admin_opc extends JFrame{
    private HashSet <Tributo> TributosVivos;
    private JTextArea l;
    private Facade fachada;
    public admin_opc(HashSet <Tributo> TributosVivos , JTextArea l, Facade fachada){
        this.TributosVivos = TributosVivos;
        this.l = l;
        this.fachada = fachada;
        setTitle("Opciones Del ADMINISTRADOR");
        setLayout(null);
        setBounds(0,0,200,100);
        setVisible(true);
        setLocationRelativeTo(null);
        setComponents();
    }
    private void setComponents(){
        JButton cv = new JButton("1");
        cv.setBounds(0,0,50,50);
        cv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                l.setText(l.getText() + "\n" + "Eligio el 1\n");
                for (Tributo tribute: TributosVivos){
                    tribute.getEstadisticas().setSalud(Math.min(tribute.getEstadisticas().getSalud()+15, tribute.getEstadisticas().getMaxSalud()));
                    tribute.getEstadisticas().setStamina(Math.min(tribute.getEstadisticas().getStamina()+15, tribute.getEstadisticas().getMaxStamina()));
                }
                dispose();
            }
        });
        add(cv);

        JButton ev = new JButton("2");
        ev.setBounds(50,0,50,50);
        ev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                l.setText(l.getText() + "\n" + "Eligio el 2\n");
                for (Tributo tribute: TributosVivos){
                    tribute.getEstadisticas().setSalud(tribute.getEstadisticas().getSalud()-15);
                    tribute.getEstadisticas().setStamina(tribute.getEstadisticas().getStamina()-10);
                }
                fachada.eliminarTributosNoVivos(l);
                dispose();
            }
        });
        add(ev);

        JButton ae = new JButton("3");
        ae.setBounds(100,0,50,50);
        ae.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                l.setText(l.getText() + "\n" + "Eligio el 3\n");
                for (Tributo tribute: TributosVivos){
                    tribute.getEstadisticas().setFuerza(tribute.getEstadisticas().getFuerza()+20);
                    tribute.getEstadisticas().setDestreza(tribute.getEstadisticas().getDestreza()+20);
                    tribute.getEstadisticas().setInteligencia(tribute.getEstadisticas().getInteligencia()+20);
                    tribute.getEstadisticas().setVelocidad(tribute.getEstadisticas().getVelocidad()+20);
                };
                dispose();
            }
        });
        add(ae);
        
    }
}
