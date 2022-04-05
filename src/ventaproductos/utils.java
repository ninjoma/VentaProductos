/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventaproductos;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author A8-PC79
 */
public class utils {
    public static void clearScreen(){
        try {
            Robot robot = new Robot();
            robot.keyPress(17);
            robot.keyPress(76);
            robot.keyRelease(17);
            robot.keyRelease(76);
        }catch (AWTException e){
            e.printStackTrace();
        }
    }
    public static void waitforEnter(){
        try {
            System.in.read();
        } catch (IOException ex) {
        }
    }
}
