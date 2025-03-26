package ejercicios_1Trimestre.ejercicio.vista;

import ejercicios_1Trimestre.ejercicio.controlador.ControladorBorrar;

import javax.swing.*;

public class VistaBorrar extends JFrame{
    private JComboBox comboBox1;
    private JButton eliminarButton;
    private JPanel panel;

    ControladorBorrar controlerBorrar = new ControladorBorrar(this);

    public VistaBorrar(){
        this.setTitle("Eliminar Cliente");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(100,100,300,200);

        eliminarButton.setActionCommand("eliminar");
        eliminarButton.addActionListener(controlerBorrar);

        this.setContentPane(panel);

    }

    public JComboBox getComboBox1() {
        return comboBox1;
    }
}
