package ejercicios_1Trimestre.informe.controlador;

import ejercicios_1Trimestre.informe.vista.Vista;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

public class Controlador implements ActionListener {

    private Vista vista;

    public Controlador(Vista vista) {
        this.vista = vista;


        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "salir" -> System.exit(0);
            case "informe" -> mostrarInformes();
        }
    }

    private void mostrarInformes() {
        // Ruta del informe .jasper
        String reportPath = "";
        try {
            switch (vista.getComboBox1().getSelectedItem().toString()){
                case "Ejercicio 1" -> reportPath = "src/main/java/ejercicios_1Trimestre/informe/Ejercicio1.jasper";
                case "Ejercicio 2" -> reportPath = "src/main/java/ejercicios_1Trimestre/informe/Ejercicio2.jasper";
                case "Ejercicio 3" -> reportPath = "src/main/java/ejercicios_1Trimestre/informe/Ejercicio3.jasper";
                case "Ejercicio 4" -> reportPath = "src/main/java/ejercicios_1Trimestre/informe/Ejercicio4.jasper";
                case "Ejercicio 5" -> reportPath = "src/main/java/ejercicios_1Trimestre/informe/Ejercicio5.jasper";
                case "Ejercicio 6" -> reportPath = "src/main/java/ejercicios_1Trimestre/informe/Ejercicio6.jasper";
                default -> JOptionPane.showMessageDialog(
                        null,
                        "Error, debes seleccionar un informe" ,
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
            // Verificar si el archivo .jasper existe
            File reportFile = new File(reportPath);
            if (!reportFile.exists()) {
                throw new FileNotFoundException("El archivo .jasper no se encontró en la ruta especificada: " + reportPath);
            }

            // Conexión a la base de datos SQLite
            String url = "jdbc:sqlite:src/main/java/ejercicios_1Trimestre/informe/Interfaces.db";
            Connection connection = DriverManager.getConnection(url);

            // Cargar el informe .jasper
            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(reportPath);
            if (report == null) {
                throw new Exception("El archivo .jasper no se pudo cargar. Verifica la ruta y el archivo.");
            }

            // Rellenar el informe con datos de la base de datos
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, new HashMap<>(), connection);

            // Mostrar el informe en una nueva ventana utilizando JasperViewer
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setVisible(true);

            // Cerrar la conexión a la base de datos
            connection.close();
        } catch (Exception ex) {
            //ex.printStackTrace();
            // Mostrar un mensaje de error si ocurre algún problema
            JOptionPane.showMessageDialog(
                    null,
                    "Error al generar el informe: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}

