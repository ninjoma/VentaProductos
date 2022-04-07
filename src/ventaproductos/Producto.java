/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventaproductos;

/**
 *
 * @author A8-PC79
 */
public class Producto {
    private String nombre;
    private int producto_id;
    private int precio;
    private String desc;
    public Producto(int producto_id, String nombre, int precio, String desc){
        this.producto_id = producto_id;
        this.nombre = nombre;
        this.precio = precio;
        this.desc = desc;
    }
    @Override
    public String toString() {
        String preciofinal = precio + ",00 €";
        return "------------------------------------------------------------" + System.lineSeparator() +
        nombre + utils.spaceGenerator(60 - nombre.length() - preciofinal.length()) + preciofinal + System.lineSeparator() +
        "Descripción: " + System.lineSeparator()
        + utils.FormattingDetector(desc, 60) + System.lineSeparator() +
        "------------------------------------------------------------";
               
    }
    
}
