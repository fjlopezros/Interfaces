package ejercicios_1Trimestre.ejercicio.main;

import ejercicios_1Trimestre.ejercicio.controlador.Controlador;
import ejercicios_1Trimestre.ejercicio.modelo.Modelo;
import ejercicios_1Trimestre.ejercicio.vista.Vista;

public class Main {
    public static void main(String[] args) {
        new Controlador(new Vista(), new Modelo());
    }
}
