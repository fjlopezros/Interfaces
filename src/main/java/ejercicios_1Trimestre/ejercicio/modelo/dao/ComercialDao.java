package ejercicios_1Trimestre.ejercicio.modelo.dao;

import ejercicios_1Trimestre.ejercicio.modelo.Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ComercialDao {

    public static List<String> rellenarCombo() {
        String query = "SELECT Nif_Comer FROM Comerciales";
        List<String> comercial = new LinkedList<>();

        try (PreparedStatement pst = Modelo.getConn().prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                comercial.add(rs.getString("Nif_Comer"));
            }

            return comercial;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
