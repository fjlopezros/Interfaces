package ejercicios_1Trimestre.informe.main;

import ejercicios_1Trimestre.informe.controlador.Controlador;
import ejercicios_1Trimestre.informe.vista.Vista;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        new Controlador(new Vista());

    }
}
