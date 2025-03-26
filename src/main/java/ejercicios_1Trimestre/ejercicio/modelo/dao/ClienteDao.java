package ejercicios_1Trimestre.ejercicio.modelo.dao;

import ejercicios_1Trimestre.ejercicio.modelo.Modelo;
import ejercicios_1Trimestre.ejercicio.modelo.orm.ClienteOrm;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ClienteDao {

    public static Map<String, String> buscarCliente(String nif) {
        String query = "SELECT Nif_Cliente,NomCliente FROM Clientes WHERE Nif_Comer = ?";
        Map<String, String> mapaCliente = new HashMap<>();

        try (PreparedStatement pst = Modelo.getConn().prepareStatement(query)) {

            pst.setString(1, nif);
            try (ResultSet rs = pst.executeQuery()) {

                while (rs.next()) {
                    mapaCliente.put(rs.getString("Nif_Cliente"), rs.getString("NomCliente"));
                }
            }
            return mapaCliente;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static List<String> rellenarCombo() {
        String query = "SELECT Nif_Cliente FROM Clientes";
        List<String> clientes = new LinkedList<>();

        try (PreparedStatement pst = Modelo.getConn().prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                clientes.add(rs.getString("Nif_Cliente"));
            }

            return clientes;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void borrarCliente(String nif) {
        String query = "DELETE FROM Clientes WHERE Nif_Cliente = ?";
        try (PreparedStatement pst = Modelo.getConn().prepareStatement(query)) {
            pst.setString(1, nif);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertarCliente(ClienteOrm cliente) {
        String query = "INSERT INTO Clientes VALUES (?, ?, ?)";
        try (PreparedStatement pst = Modelo.getConn().prepareStatement(query)) {
            pst.setString(1, cliente.getNif());
            pst.setString(2, cliente.getNombre());
            pst.setString(3, cliente.getNifComercial());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void modificarCliente(ClienteOrm c, String dni) {
        String query = "UPDATE Clientes SET Nif_Cliente = ?, NomCliente = ? WHERE Nif_Cliente = ?";
        try (PreparedStatement pst = Modelo.getConn().prepareStatement(query)) {
            pst.setString(1, c.getNif());
            pst.setString(2, c.getNombre());
            pst.setString(3, dni);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
