/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventaproductos;

/**
 *
 * @author A8-PC79
 */
public class Usuario {
    private String usuario;
    private String pass;
    private int cliente_id;
    public Usuario(String usuario, String pass, int cliente_id){
        this.usuario = usuario;
        this.pass = pass;
        this.cliente_id = cliente_id;
    }

    public String getUsuario() {
        return usuario;
    }

}
