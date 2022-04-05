/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventaproductos;

import java.io.Console;

/**
 *
 * @author A8-PC79
 */
public class Menu {
    public static void Login(){
        System.out.println("Login" + System.lineSeparator()
        + "Introduzca su usuario: ");
        String usuario = Entrada.RequestString();
        System.out.println("Introduzca su contraseña: ");
        String pass = Entrada.RequestString();
        
    }
}
