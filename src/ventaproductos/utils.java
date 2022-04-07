/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventaproductos;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;

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
    public static String spaceGenerator(int count){
        String spaces = "";
        for (int i = 0; i < count; i++) {
            spaces += " ";
        }
        return spaces;
    }
    public static String FormattingDetector(String inputString, int breakline){
        String formattedtext = "";
        System.out.println(Math.floor(inputString.length()/breakline));
        for (int i = 0; i < Math.floor(inputString.length()/breakline); i++) {
            formattedtext += inputString.substring((breakline*i), (breakline*(i+1)))
                           + System.lineSeparator();
        }
        return formattedtext.substring(0,formattedtext.length() -1);
    }
}
