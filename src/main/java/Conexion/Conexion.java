/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.*;

public class Conexion {
    
        
    private static final String UBICACION_BD = "ProyectosConstruccion.db";
    String url = "jdbc:sqlite:" + UBICACION_BD;
    
       
    String strConexionDB = url;
    
    Connection conn = null;
    
    public Conexion() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);

            System.out.println("Conexion establacida");
        } catch (Exception e) {
            System.out.println("Error de conexion " + e);
        }
    }
    
    
    public ResultSet consultarRegistros(String url){
        try {
            PreparedStatement pstm = conn.prepareStatement(url);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    
}
