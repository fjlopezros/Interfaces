package ejercicios_1Trimestre.ejercicio.vista;

import ejercicios_1Trimestre.ejercicio.controlador.Controlador;
import ejercicios_1Trimestre.ejercicio.modelo.Modelo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Vista extends JFrame {

    private JPanel panel1;
    private JButton mostrarButton1;
    private JButton borrarButton;
    private JButton insertarButton;
    private JButton modificarButton;
    private JComboBox comboBox1;
    private JTable table1;

    private DefaultTableModel tablaModel;

    Controlador controlador = new Controlador(this, new Modelo());

    public Vista(){
        this.setTitle("Aplicacion Gestoria");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(100,100,700,600);
        this.setResizable(false);

        mostrarButton1.setActionCommand("mostrar");
        mostrarButton1.addActionListener(controlador);

        borrarButton.setActionCommand("borrar");
        borrarButton.addActionListener(controlador);

        insertarButton.setActionCommand("insertar");
        insertarButton.addActionListener(controlador);

        modificarButton.setActionCommand("modificar");
        modificarButton.addActionListener(controlador);

        tablaModel = new DefaultTableModel(new String[]{"DNI","Nombre"},0);
        table1.setModel(tablaModel);

        this.setContentPane(panel1);

    }

    public JComboBox getComboBox1() {
        return comboBox1;
    }

    public DefaultTableModel getTablaModel() {
        return tablaModel;
    }
}
