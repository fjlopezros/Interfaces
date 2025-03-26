package ejercicios_1Trimestre.ejercicio.vista;

import ejercicios_1Trimestre.ejercicio.controlador.ControladorModificar;

import javax.swing.*;

public class VistaModificar extends JFrame{
    private JComboBox comboBox1;
    private JLabel label1;
    private JPanel panel;
    private JTextField textField1;
    private JTextField textField2;
    private JButton actualizarButton;

    ControladorModificar controlerModificar = new ControladorModificar(this);

    public VistaModificar(){
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(100,100,500,500);
        this.setTitle("Modificar Cliente");

        if(comboBox1.getSelectedItem() == null){
            textField1.setEnabled(false);
            textField2.setEnabled(false);
            actualizarButton.setEnabled(false);
        }else {
            actualizarButton.setActionCommand("modificar");
            actualizarButton.addActionListener(controlerModificar);
        }
        this.setContentPane(panel);
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public JTextField getTextField2() {
        return textField2;
    }

    public JComboBox getComboBox1() {
        return comboBox1;
    }
}
