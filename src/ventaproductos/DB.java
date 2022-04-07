/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventaproductos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author A8-PC79
 */
public class DB {

    private Connection conn;

    public DB() {
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE",
                    "NULLSOFT", "NULLSOFT");
            conn.setAutoCommit(true);
            System.out.println("Conexion a la base de datos correcta");
            if (conn == null) {
                System.out.println("No se pudo conectar a la base de datos");
            }
        } catch (SQLException Ex) {
            System.err.format("SQL State: %s\n%s", Ex.getSQLState(), Ex.getMessage());
        }
    }

    public Usuario validarLogin(String usuario, String pass) { //Null si no existe el usuario
        int clienteID;
        try {
            Statement stmt = conn.createStatement();
            //String queryUsuario = "SELECT * FROM CLIENTE WHERE USUARIO= '" + usuario+"';";
            String queryUsuario = "SELECT * FROM CLIENTE";
            String queryContrasenya = "SELECT PASSW FROM CLIENTE WHERE PASSW= '" + pass + "'";
            String queryid = "SELECT ID_CLIENTE FROM CLIENTE WHERE USUARIO= '" + usuario + "'"
                    + " AND PASSW= '" + pass + "'";
            ResultSet rs = stmt.executeQuery(queryUsuario);

            if (rs.next() == false) {
                return null;
            } else {
                rs = stmt.executeQuery(queryContrasenya);
                if (rs.next() == false) {
                    System.out.println("Contraseña incorrecta");
                    return null;
                } else {
                    System.out.println("El usuario existe");
                    rs = stmt.executeQuery(queryid);
                    rs.next();
                    clienteID = ((Number) rs.getObject(1)).intValue();
                    Usuario user = new Usuario(usuario, pass, clienteID);
                    System.out.println("El usuario existe");
                    return user;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
