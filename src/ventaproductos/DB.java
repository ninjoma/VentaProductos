/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventaproductos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author A8-PC79
 */
public class DB {
    private Connection conn;
    public DB(){
        try{
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", 
                    "NULLSOFT", "NULLSOFT");
            if(conn == null){
                System.out.println("No se pudo conectar a la base de datos");
            }
        } catch(SQLException Ex){
            System.err.format("SQL State: %s\n%s", Ex.getSQLState(), Ex.getMessage());
        }
    }
    public boolean validarLogin(String usuario, String pass) {
        
    }
    
}
