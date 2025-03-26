package ejercicios_1Trimestre.ejercicio.modelo.orm;

public class ClienteOrm {
    private String nif;
    private String nombre;
    private String nifComercial;

    // Constructor
    public ClienteOrm(String nif, String nombre, String nifComercial) {
        this.nif = nif;
        this.nombre = nombre;
        this.nifComercial = nifComercial;
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

    public String getNifComercial() {
        return nifComercial;
    }

    public void setNifComercial(String nifComercial) {
        this.nifComercial = nifComercial;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nif='" + nif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", nifComercial='" + nifComercial + '\'' +
                '}';
    }
}


