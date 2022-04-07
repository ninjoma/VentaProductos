/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventaproductos;


/**
 *
 * @author A8-PC79
 */
public class Menu {
    private DB db = new DB();
    private Usuario user;
    public Menu(){
        System.out.println("¡Bienvenido a NullSoft, tu todo a cien de confianza!");
        Login();
    }
    private void Login(){
        System.out.println("Introduzca su usuario: ");
        String usuario = Entrada.RequestString();
        System.out.println("Introduzca su contraseña: ");
        String pass = Entrada.RequestString();
        user = db.validarLogin(usuario, pass);
        if(user != null){
            utils.clearScreen();
            Store();
        } else {
            System.out.println("¡El usuario no existe! Inténtalo de nuevo");
            Login();
        }
    }
    private void Store(){
        System.out.println("Tienda -------------------- Hola, " + user.getUsuario());
        
    }
    
}
