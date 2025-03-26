package ejercicios_1Trimestre.informe.vista;

import ejercicios_1Trimestre.informe.controlador.Controlador;

import javax.swing.*;

public class Vista extends JFrame {
    private JPanel panel;
    private JButton mostrarInformeButton;
    private JButton salirButton;
    private JLabel etiqueta;
    private JComboBox comboBox1;

    private Controlador controlador = new Controlador(this);

    public Vista() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(100, 100, 500, 500);

        this.setContentPane(panel);

        salirButton.setActionCommand("salir");
        salirButton.addActionListener(controlador);

        mostrarInformeButton.setActionCommand("informe");
        mostrarInformeButton.addActionListener(controlador);

        this.setVisible(true);
    }

    public JComboBox getComboBox1() {
        return comboBox1;
    }
}
