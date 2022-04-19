/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventaproductos;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author A8-PC79
 */
public class Entrada {
    private static Scanner sc = new Scanner(System.in);
    public static int RequestNumber(String prevtext){
        Integer result = null;
        System.out.print("" + prevtext);
        while(result == null){
            try{
                result = sc.nextInt();
            } catch(InputMismatchException Ex) {
                System.out.println("Has introducido un número inválido. Por favor,"
                        + " inténtalo de nuevo.");
            }            
        }
       return (int) result;
    }
    public static String RequestString(String prevtext){
        String result = "";
        System.out.print("" + prevtext);
        while(result.equals("")){
            try{
                result = sc.nextLine();
            } catch(Exception Ex) {
                System.out.println("Has introducido una String inválida. Por favor,"
                        + " inténtalo de nuevo.");
            }
        }
       return result;
    }
}
