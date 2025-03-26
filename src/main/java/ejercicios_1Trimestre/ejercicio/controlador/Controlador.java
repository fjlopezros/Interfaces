package ejercicios_1Trimestre.ejercicio.controlador;


import ejercicios_1Trimestre.ejercicio.modelo.Modelo;
import ejercicios_1Trimestre.ejercicio.modelo.dao.ClienteDao;
import ejercicios_1Trimestre.ejercicio.modelo.dao.ComercialDao;
import ejercicios_1Trimestre.ejercicio.vista.Vista;
import ejercicios_1Trimestre.ejercicio.vista.VistaBorrar;
import ejercicios_1Trimestre.ejercicio.vista.VistaInsertar;
import ejercicios_1Trimestre.ejercicio.vista.VistaModificar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class Controlador implements ActionListener {
    private Vista vista;
    private Modelo modelo;

    public Controlador(Vista vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;

        modelo.conectar();

        rellenarCombo();

        vista.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "mostrar" -> mostrarTabla();
            case "borrar" -> new ControladorBorrar(new VistaBorrar());
            case "insertar" -> new ControladorInsertar(new VistaInsertar());
            case "modificar" -> new ControladorModificar(new VistaModificar());
        }
    }
    private void rellenarCombo(){
        vista.getComboBox1().removeAllItems();
        List<String> comercial = ComercialDao.rellenarCombo();
        for(String dni:  comercial) vista.getComboBox1().addItem(dni);
    }

    private void mostrarTabla() {
        try {
            // Obtener el elemento seleccionado del ComboBox
            String comboSeleccionado = vista.getComboBox1().getSelectedItem().toString();

            if (comboSeleccionado == null || comboSeleccionado.isBlank()) {
                JOptionPane.showMessageDialog(null,
                        "Selecciona un DNI",
                        "Error lista",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Llamar al DAO para obtener el Map de clientes
            Map<String, String> mapaClientes = ClienteDao.buscarCliente(comboSeleccionado);

            // Verificar si el mapa está vacío
            if (mapaClientes == null || mapaClientes.isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "No se encontraron clientes para este comercial.",
                        "Información",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            // Limpiar la tabla antes de agregar nuevas filas (opcional)
            vista.getTablaModel().setRowCount(0);

            // Recorrer el Map y añadir filas a la tabla
            for (Map.Entry<String, String> entry : mapaClientes.entrySet()) {
                vista.getTablaModel().addRow(new Object[]{
                        entry.getKey(), // Clave: NIF del cliente
                        entry.getValue() // Valor: Nombre del cliente
                });
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null,
                    "Error inesperado: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al mostrar los datos: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}

