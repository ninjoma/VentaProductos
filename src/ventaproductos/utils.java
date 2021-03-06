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
    private static final Robot robot;
    static {
        Robot tmp = null;
        try {
            tmp = new Robot();
        } catch (AWTException ex) {
           
        }
        robot = tmp;
    }
    public static void clearScreen(){
        robot.keyPress(17);
        robot.keyPress(76);
        robot.keyRelease(17);
        robot.keyRelease(76);
        robot.delay(100);
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
       
        if(inputString.length() <= breakline){
            return inputString;
        } else {
            String formattedtext = "";
            int lines = (int) Math.floor(inputString.length()/breakline);
            for (int i = 0; i < lines; i++) {
                formattedtext += inputString.substring((breakline*i),(breakline*(i+1))) + System.lineSeparator();
            }
            formattedtext += inputString.substring((lines*breakline), inputString.length());
            return formattedtext;
            //return formattedtext.substring(0,formattedtext.length() -1);
        }
    }
    public static String Spacer(){
        return "------------------------------------------------------------";
    }
}
