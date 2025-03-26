package ejercicios_1Trimestre.ejercicio.vista;

import ejercicios_1Trimestre.ejercicio.controlador.ControladorInsertar;

import javax.swing.*;

public class VistaInsertar extends JFrame{
    private JLabel label1;
    private JPanel panel;
    private JTextField textField1;
    private JTextField textField2;
    private JButton enviarButton;

    ControladorInsertar controlerInsertar = new ControladorInsertar(this);

    public VistaInsertar(){
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(100,100,500,500);

        enviarButton.setActionCommand("insertar");
        enviarButton.addActionListener(controlerInsertar);

        this.setContentPane(panel);
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public JTextField getTextField2() {
        return textField2;
    }
}
