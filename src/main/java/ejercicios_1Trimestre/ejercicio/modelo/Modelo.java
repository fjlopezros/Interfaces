package ejercicios_1Trimestre.ejercicio.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Modelo {
    private static final String URL = "jdbc:sqlite:src/main/java/ejercicios_1Trimestre/ejercicio/Gestor.db";
    private static Connection conn;

    public Modelo(){
        conectar();
    }

    public static Connection getConn() {
        return conn;
    }

    public void conectar(){
        try{
            conn = DriverManager.getConnection(URL);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void cerrarConn(){
        try{
            if(conn!=null){
                conn.close();
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
