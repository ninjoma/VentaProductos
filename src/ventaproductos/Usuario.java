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
    private boolean esAdmin;
    public Usuario(String usuario, String pass, boolean esAdmin, int cliente_id){
        this.usuario = usuario;
        this.pass = pass;
        this.cliente_id = cliente_id;
        this.esAdmin = esAdmin;
    }

    public String getUsuario() {
        return usuario;
    }

    public boolean isEsAdmin() {
        return esAdmin;
    }

    public int getCliente_id() {
        return cliente_id;
    }
    
}
