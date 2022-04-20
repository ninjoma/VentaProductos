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
import java.util.Scanner;

/**
 *
 * @author A8-PC79
 */
public class DB {

    public static Connection conn;

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
            String query = "SELECT NOMBRE FROM PRODUCTO WHERE NOMBRE= '" + productName.toUpperCase() + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next() == false) {
                return null;
            } else {
                query = "SELECT ID_PRODUCTO, NOMBRE, PRECIO, DESCRIPCION FROM PRODUCTO WHERE NOMBRE = '" + productName.toUpperCase() + "'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    String id_producto = rs.getNString("ID_PRODUCTO");
                    int id_pr = rs.getInt("ID_PRODUCTO");
                    String nombre = rs.getNString("NOMBRE");
                    int precio = rs.getInt("PRECIO");
                    String descripcion = rs.getNString("DESCRIPCION");
                    Producto pr = new Producto(id_pr, nombre, precio, descripcion);
                    return pr;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean registroUsuario(String usuario, String pass, String nombre, String apellido, int edad) { //Si =false no se pudo registrar
        int id_cliente;
        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT USUARIO FROM CLIENTE WHERE USUARIO = '" + usuario + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next() != false) {
                String comprobarUser = rs.getNString("USUARIO");
                if (comprobarUser.equals(usuario)) {
                    System.out.println("Este usuario ya existe");
                    return false;
                }
            } else {
                query = "SELECT COUNT(*) FROM CLIENTE";
                rs = stmt.executeQuery(query);
                rs.next();
                id_cliente = rs.getInt(1) + 1;
                query = "INSERT INTO CLIENTE "
                        + "VALUES (" + id_cliente + ", '" + nombre + "', '" + apellido + "', " + edad + ", " + 0 + ", '" + usuario + "', '" + pass + "', " + 0 + ")";
                rs.next();
                rs = stmt.executeQuery(query);
                System.out.println("Usuario creado correctamente");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean modificarUser(int id_cliente) {
        try {
            Scanner sc = new Scanner(System.in);
            Statement stmt = conn.createStatement();
            System.out.println("Introduce tus nuevos datos, vamos a actualizarlos");
            System.out.println("Introduce tu nuevo usuario");
            String usuario = sc.nextLine();
            System.out.println("Introduce tu nueva contraseña");
            String contrasenya = sc.nextLine();
            System.out.println("Introduce tu edad");
            int edad = sc.nextInt();

            String query = "UPDATE CLIENTE SET USUARIO='" + usuario + "', PASSW='" + contrasenya + "', EDAD=" + edad + " WHERE ID_CLIENTE=" + id_cliente + "";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next() == false) {
                System.out.println("No se pudo modificar el usuario");
                return false;
            } else {
                System.out.println("Usuario modificado");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
