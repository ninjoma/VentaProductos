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
        Login();
    }
    private void Login(){
        System.out.println("¡Bienvenido a NullSoft, tu todo a cien online de confianza!");
        System.out.println("Introduzca su usuario: ");
        String usuario = Entrada.RequestString();
        System.out.println("Introduzca su contraseña: ");
        String pass = Entrada.RequestString();
        user = db.validarLogin(usuario, pass);
        utils.clearScreen();
        if(user != null){
            Store();
        } else {
            System.out.println("¡El usuario no existe! Inténtalo de nuevo");
            Login();
        }
    }
    private void Store(){
        System.out.println("Tienda NullSoft -------------------- Hola, USUARIO " + user.getUsuario());
        System.out.println("Escribe un número para acceder a cada menú:");
        System.out.println("1 - Buscar un producto. ");
        System.out.println("2 - Ajustes de cuenta.");
        System.out.println("3 - Salir.");
        int seleccion = Entrada.RequestNumber();
        if(!(seleccion > 0 && seleccion < 4)){
            Store();
        }
        switch(seleccion){
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                
                break;
        }
        
    }
    
}
