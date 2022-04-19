/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventaproductos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.JDBCType;
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
            String query = "SELECT USER FROM CLIENTE WHERE USUARIO= '" + usuario + "'";
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next() == false) {
                return null;
            } else {
                query = "SELECT PASSW FROM CLIENTE WHERE PASSW= '" + pass + "'";
                rs = stmt.executeQuery(query);
                if (rs.next() == false) {
                    System.out.println("Contraseña incorrecta");
                    return null;
                } else {
                    System.out.println("El usuario existe");
                    query = "SELECT ID_CLIENTE FROM CLIENTE WHERE USUARIO= '" + usuario + "'"
                            + " AND PASSW= '" + pass + "'";
                    rs = stmt.executeQuery(query);
                    rs.next();
                    clienteID = ((Number) rs.getObject(1)).intValue();
                    Usuario user = new Usuario(usuario, pass, clienteID);
                    return user;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Producto buscarProducto(String productName) {
        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT NOMBRE FROM PRODUCTO WHERE NOMBRE= '" + productName + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next() == false) {
                return null;
            } else {
                query = "SELECT ID_PRODUCTO, NOMBRE, PRECIO, DESCRIPCION FROM PRODUCTO WHERE NOMBRE = '" + productName + "'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    String id_producto = rs.getString(1);
                    id_producto = id_producto.toString();
                    int id_pr = Integer.parseInt(id_producto);
                    String nombre = rs.getString(2);
                    int precio = ((Number) rs.getObject(3)).intValue();
                    String descripcion = rs.getString(4);
                    Producto pr = new Producto(id_pr, nombre, precio, descripcion);
                    return pr;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
