package ejercicios_1Trimestre.ejercicio.modelo.orm;

public class ComercialOrm {
    private String nif;
    private String nombre;

    // Constructor
    public ComercialOrm(String nif, String nombre) {
        this.nif = nif;
        this.nombre = nombre;
    }

    // Getters y Setters
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Comercial{" +
                "nif='" + nif + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

