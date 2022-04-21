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

    public Menu() {
        EnterWebsite();
    }

    private void EnterWebsite(){
        utils.clearScreen();
        System.out.println("¡Bienvenido a NullSoft! Escribe 1 para loguearte o "
                + " 2 para registrarte");
        int seleccion = Entrada.RequestNumber(">");
        if (!(seleccion > 0 && seleccion < 3)) {
            EnterWebsite();
        }
        switch (seleccion) {
            case 1:
                Login();
                break;
            case 2:
                Register();
                break;
        }
    }

    private void Register(){
        utils.clearScreen();
        System.out.println("Registro:");
        System.out.println("Introduce un usuario:");
        String usuario = Entrada.RequestString(">");
        System.out.println("Introduce una contraseña:");
        String pass = Entrada.RequestString(">");
        System.out.println("Introduce tu nombre:");
        String nombre = Entrada.RequestString(">");
        System.out.println("Introduce tu apellido:");
        String apellido = Entrada.RequestString(">");
        System.out.println("Introduce tu edad:");
        int edad = Entrada.RequestNumber(">");
        if(db.registroUsuario(usuario, pass, nombre, apellido, edad)){
            System.out.println("¡Usuario Creado satisfactoriamente! Vuelve"
                    + " a loguearte con tus datos. Pulsa Enter para Continuar.");
            utils.waitforEnter();
            Login();
        } else {
            System.out.println("Pulsar Enter te devolverá a la pantalla de selección.");
            utils.waitforEnter();
            EnterWebsite();
        }
        
    }
    
    private void Login() {
        utils.clearScreen();
        System.out.println("Login:");
        System.out.println("Introduzca su usuario: ");
        String usuario = Entrada.RequestString(">");
        System.out.println("Introduzca su contraseña: ");
        String pass = Entrada.RequestString(">");
        user = db.validarLogin(usuario, pass);
        if (user != null) {
            if(user.isEsAdmin()){
                AdminMenu();
            } else {
                UserStore();
            }
        } else {
            System.out.println("¡El usuario no existe! Inténtalo de nuevo");
            Login();
        }
    }

    private void AdminMenu(){
        utils.clearScreen();
        System.out.println("Tienda NullSoft -------------------- Hola, ADMINISTRADOR " + user.getUsuario());
        System.out.println("Escribe un número para acceder a cada menú:");
        System.out.println("1 - Eliminar un producto. ");
        System.out.println("2 - Ajustes de cuenta.");
        System.out.println("3 - Salir.");
        int seleccion = Entrada.RequestNumber(">");
        if (!(seleccion > 0 && seleccion < 4)) {
            AdminMenu();
        }
        switch (seleccion) {
            case 1:
                DeleteProduct();
                break;
            case 2:
                ModifyAccount();
                break;
            case 3:
                Exit();
                break;
        }
    }
    
    
    
    private void UserStore() {
        utils.clearScreen();
        System.out.println("Tienda NullSoft -------------------- Hola, USUARIO " + user.getUsuario());
        System.out.println("Escribe un número para acceder a cada menú:");
        System.out.println("1 - Buscar un producto. ");
        System.out.println("2 - Ajustes de cuenta.");
        System.out.println("3 - Salir.");
        int seleccion = Entrada.RequestNumber(">");
        if (!(seleccion > 0 && seleccion < 4)) {
            UserStore();
        }
        switch (seleccion) {
            case 1:
                Search();
                break;
            case 2:
                ModifyAccount();
                break;
            case 3:
                Exit();
                break;
        }

    }

    private void Search() {
        utils.clearScreen();
        System.out.println("Buscador de productos:");
        System.out.println(utils.Spacer());
        System.out.println("Introduzca el nombre del producto a buscar:");
        String productName = Entrada.RequestString(">");
        Producto searchedProduct = db.buscarProducto(productName);
        if (searchedProduct == null) {
            System.out.println("El producto especificado no pudo ser encontrado.");
            System.out.println("¿Desea volver al menú (1) o buscar otro producto (2)?");
            int seleccion = Entrada.RequestNumber(">");
            if (!(seleccion > 0 && seleccion < 3)) {
                seleccion = 1;
            }
            switch (seleccion) {
                case 1:
                    UserStore();
                    break;
                case 2:
                    Search();
                    break;
            }
        } else {
            utils.clearScreen();
            System.out.println("¡Producto encontrado!");
            System.out.println(searchedProduct.toString());
            System.out.println("¿Es este el producto que buscabas?");
            System.out.println("Escribe 1 para COMPRAR, 2 para volver a buscar o 3 para volver al menú");
            int seleccion = Entrada.RequestNumber(">");
            if (!(seleccion > 0 && seleccion < 4)) {
                seleccion = 1;
            }
            switch (seleccion) {
                case 1:
                    System.out.println("¡Has comprado " + searchedProduct.getNombre() + "!");
                    System.out.println("¡Gracias por confiar en Null Soft!");
                    System.out.println("Pulsa el ENTER para volver al menú.");
                    utils.waitforEnter();
                    UserStore();
                    break;
                case 2:
                    Search();
                    break;
                case 3:
                    UserStore();
                    break;
            }
        }
    }
    
    private void DeleteProduct(){
        utils.clearScreen();
        System.out.println("Eliminador de productos:");
        System.out.println(utils.Spacer());
        System.out.println("Introduzca el nombre del producto a eliminar:");
        String productName = Entrada.RequestString(">");
        boolean transactionResult = db.borrarProducto(productName);
        if(transactionResult == true){
            System.out.println("El producto se eliminó satisfactoriamente.");
            System.out.println("¿Quieres eliminar otro producto?");
        } else {
            System.out.println("No se encontró el producto especificado.");
        }
        System.out.println("Introduce 1 para volver al menú o 2 para eliminar"
                        + " otro producto");
        int seleccion = Entrada.RequestNumber(">");
            if (!(seleccion > 0 && seleccion < 3)) {
                seleccion = 1;
            }
            switch (seleccion) {
                case 1:
                    AdminMenu();
                    break;
                case 2:
                    DeleteProduct();
                    break;
            }
    }
    
    
    
    private void ModifyAccount(){
        System.out.println("Formulario para modificar la cuenta de usuario:");
        System.out.println("Introduce tu nuevo usuario, " + user.getUsuario() + ":");
        String usuario = Entrada.RequestString(">");
        System.out.println("Introduce tu nueva contraseña: ");
        String pass = Entrada.RequestString(">");
        System.out.println("Introduce tu edad: ");
        int edad = Entrada.RequestNumber(">");
        if(db.modificarUser(user.getCliente_id(), usuario, pass, edad) == true){
            System.out.println("¡Usuario modificado satisfactoriamente!");
        } else {
            System.out.println("Hubo un problema con la actualización de la cuenta"
                    + "de usuario.");
        }
        System.out.println("Volviendo a la pantalla de inicio de sesión");
        System.out.println("Pulsa ENTER para continuar...");
        utils.waitforEnter();
        EnterWebsite();
        user = null;
    }
    
    private void Exit(){
        System.out.println("¡Gracias por confiar en NullSoft!");
        System.out.println("¡Que tenga un buen día!");
    }
}
