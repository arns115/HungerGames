package interfaz_grafica;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import participantes.Tributo;
import principal.Facade;
public class ganador extends JFrame implements ActionListener{
    private Facade fachada;
    private ImageIcon man = new ImageIcon("Recursos/halfbody_silhouette_of_a_faceless_man.png"),
                     woman = new ImageIcon("Recursos/halfbody_silhouette_of_a_faceless_woman.png");

    public ganador(Facade fachada){
        this.fachada = fachada;
        setTitle("GANADOR");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setBounds(0,0,500,500);
        setVisible(false);

        setLocationRelativeTo(null);
        set_components();
    }

    private void set_components(){
        String sx= "";

        JLabel l1 = new JLabel("El ganador es:");
        l1.setBounds(200,10,200,20);
        l1.setForeground(Color.white);
        add(l1);
        
        
        JLabel winner = new JLabel();
        for(Tributo tributo: fachada.get_tributos_vivos_hash()){
            winner.setText(tributo.getNombre());
            sx = tributo.getEstadisticas().getSexo();
        }
        winner.setBounds(200,30,200,20);
        winner.setForeground(Color.white);
        add(winner);
        
        if(sx.equals("H")){
            JLabel iconW = new JLabel(man);
            iconW.setBounds(0,10,512,512);
            add(iconW);
        }else{
            JLabel iconW = new JLabel(woman);
            iconW.setBounds(0,10,512,512);
            add(iconW);
        }

        JButton b1 = new JButton("Regresar al inicio");
        b1.setBounds(150,350,100,50);
        b1.addActionListener(this);
        
        add(b1);


    }
    @Override
    public void actionPerformed(ActionEvent e){
        pantalla_principal pant = new pantalla_principal();

        pant.setVisible(true);
        this.setVisible(false);
        dispose();
    }
}
