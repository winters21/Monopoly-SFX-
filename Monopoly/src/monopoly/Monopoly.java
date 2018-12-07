/*
MONOPOLY ASSIGNMENT
By: Shawn Sun, Christopher Jordan, Gabriel Martell, and Bryce Batten
ICS3U
*/
package monopoly;

import java.io.IOException;
import javax.swing.JFrame;

public class Monopoly {
    
    public static void main(String[] args) throws IOException {
        JFrame HUD = new JFrame();
        HUD.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        HUD.setSize(1800, 1000);
        HUD.setLayout(null);
        
        String text = "rules.txt";
        ProcessBuilder rules = new ProcessBuilder("Notepad.exe", text);
        
        rules.start();

        HUD.setVisible(true);
           }
    
}
