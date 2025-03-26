package supuestoPractico8.mvc.view;

import javax.swing.*;

public class Principal extends JFrame{
    private JPanel pane;
    private JTextField textField1;
    private JButton button1;
    private JMenuItem itemAyuda;

    public Principal(){
        this.setTitle("Principal");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(100,100,250,100);
    }

    public JPanel getPane() {
        return pane;
    }

    public JButton getButton1() {
        return button1;
    }

    public JMenuItem getItemAyuda() {
        return itemAyuda;
    }
}
