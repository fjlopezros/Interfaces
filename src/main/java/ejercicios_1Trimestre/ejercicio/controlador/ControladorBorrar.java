package ejercicios_1Trimestre.ejercicio.controlador;

import ejercicios_1Trimestre.ejercicio.modelo.dao.ClienteDao;
import ejercicios_1Trimestre.ejercicio.vista.VistaBorrar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

public class ControladorBorrar implements ActionListener {
    private VistaBorrar vistaBorrar;

    public ControladorBorrar(VistaBorrar vistaBorrar) {
        this.vistaBorrar = vistaBorrar;

        rellenarCombo();

        vistaBorrar.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "eliminar" -> eliminar();
        }
    }

    private void rellenarCombo() {
        vistaBorrar.getComboBox1().removeAllItems();
        List<String> cliente = ClienteDao.rellenarCombo();
        vistaBorrar.getComboBox1().addItem(" ");
        for (String dni : cliente) vistaBorrar.getComboBox1().addItem(dni);
    }

    private void eliminar() {
        try {
            // Obtener el elemento seleccionado del ComboBox
            String comboSeleccionado = vistaBorrar.getComboBox1().getSelectedItem().toString();

            if (comboSeleccionado == null || comboSeleccionado.isBlank()) {
                JOptionPane.showMessageDialog(null,
                        "Selecciona un DNI",
                        "Error lista",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            ClienteDao.borrarCliente(comboSeleccionado);

            JOptionPane.showMessageDialog(null,
                    "Cliente eliminado correctamente",
                    "Correcto",
                    JOptionPane.INFORMATION_MESSAGE);

            vistaBorrar.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al mostrar los datos: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
