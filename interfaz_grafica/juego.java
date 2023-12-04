package interfaz_grafica;

import javax.swing.*;

public class juego extends JFrame {
    public int opc;
    private int acceso;
    public juego(int acceso){
        this.acceso = acceso;
        setLayout(null);
        setBounds(0,0,400,400);
        setVisible(false);
        setLocationRelativeTo(null);
    }
}
