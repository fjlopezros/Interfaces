package ejercicios_1Trimestre.ejercicio.controlador;

import ejercicios_1Trimestre.ejercicio.modelo.dao.ClienteDao;
import ejercicios_1Trimestre.ejercicio.modelo.orm.ClienteOrm;
import ejercicios_1Trimestre.ejercicio.vista.VistaModificar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControladorModificar implements ActionListener {
    private VistaModificar vM;

    public ControladorModificar(VistaModificar vM) {
        this.vM = vM;

        rellenarCombo();

        vM.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "modificar" -> modificarCliente();
        }
    }

    private void rellenarCombo() {
        vM.getComboBox1().removeAllItems();
        List<String> cliente = ClienteDao.rellenarCombo();
        vM.getComboBox1().addItem(" ");
        for (String dni : cliente) vM.getComboBox1().addItem(dni);
    }

    private void modificarCliente() {
        String dni = vM.getTextField1().getText();
        String nombre = vM.getTextField2().getText();
        String combo = vM.getComboBox1().getSelectedItem().toString();


        if (combo != null && dni != null && nombre != null) {
            ClienteOrm c = new ClienteOrm(dni, nombre, combo);
            ClienteDao.modificarCliente(c, combo);

            JOptionPane.showMessageDialog(null,
                    "Actualizado correctamente",
                    "Confirmado",
                    JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null,
                    "Por favor, completa todos los campos.",
                    "Error de Validación",
                    JOptionPane.ERROR_MESSAGE);
        }

        vM.dispose();
    }
}
