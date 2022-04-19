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
        String usuario = Entrada.RequestString(">");
        System.out.println("Introduzca su contraseña: ");
        String pass = Entrada.RequestString(">");
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
        int seleccion = Entrada.RequestNumber(">");
        if(!(seleccion > 0 && seleccion < 4)){
            utils.clearScreen();
            Store();
        }
        utils.clearScreen();
        switch(seleccion){
            case 1:
                    Search();
                break;
            case 2:
                
                break;
            case 3:
                
                break;
        }
        
    }
    private void Search(){
        System.out.println("Buscador de productos:");
        System.out.println(utils.Spacer());
        System.out.println("Introduzca el nombre del producto a buscar:");
        String productName = Entrada.RequestString(">");
        Producto searchedProduct = db.buscarProducto(productName);
        if(searchedProduct == null){
            System.out.println("El producto especificado no pudo ser encontrado.");
            System.out.println("¿Desea volver al menú (1) o buscar otro producto (2)?");
            int seleccion = Entrada.RequestNumber(">");
            while(!(seleccion > 0 && seleccion < 3)){
                System.out.println("Introduce 1 para volver al menú o 2 para buscar"
                        + " otro producto");
                seleccion = Entrada.RequestNumber(">");
            }
            switch(seleccion){
                case 1:
                    Store();
                    break;
                case 2:
                    Search();
                    break;
            }
        } else {
            utils.clearScreen();
            System.out.println("¡Producto encontrado!");
            System.out.println(searchedProduct.toString());
        }
    }
    
}
