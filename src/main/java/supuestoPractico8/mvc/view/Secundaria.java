package supuestoPractico8.mvc.view;

import javax.swing.*;

public class Secundaria extends JFrame {

    private JPanel panel1;

    public Secundaria(){
        this.setTitle("Secundaria");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(100,100,400,250);
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
