package ejercicios_1Trimestre.ejercicio.controlador;

import ejercicios_1Trimestre.ejercicio.modelo.dao.ClienteDao;
import ejercicios_1Trimestre.ejercicio.modelo.dao.ComercialDao;
import ejercicios_1Trimestre.ejercicio.modelo.orm.ClienteOrm;
import ejercicios_1Trimestre.ejercicio.vista.VistaInsertar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ControladorInsertar implements ActionListener {

    private VistaInsertar vI;

    public ControladorInsertar(VistaInsertar vI){
        this.vI = vI;


        vI.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "insertar" -> insertarCliente();
        }
    }

    private void insertarCliente() {
        String dni = vI.getTextField1().getText();
        String nombre = vI.getTextField2().getText();

        if(dni != null && nombre != null){
            Random random = new Random();
            List<String> comerciales = ComercialDao.rellenarCombo();
            String comercialAleatorio = comerciales.get(random.nextInt(comerciales.size() - 1));

            ClienteOrm clienteOrm = new ClienteOrm(dni,nombre,comercialAleatorio);
            ClienteDao.insertarCliente(clienteOrm);


            JOptionPane.showMessageDialog(null,
                    "Cliente insertado correctamente",
                    "Correcto",
                    JOptionPane.INFORMATION_MESSAGE);

            vI.dispose();
        }else{
            JOptionPane.showMessageDialog(null,
                    "Rellena todos los campos",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
