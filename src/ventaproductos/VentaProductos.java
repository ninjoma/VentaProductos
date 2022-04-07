/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ventaproductos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author A8-PC79
 */
public class VentaProductos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DB db = new DB();
        System.out.println("¡Bienvenido a NullSoft Inc! Tu todo a cien online"
                + " de confianza.");
        Menu.Login();
    }
    
}
