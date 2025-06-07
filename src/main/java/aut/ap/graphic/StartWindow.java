package aut.ap.graphic;
import javax.swing.*;
import java.awt.*;


public class StartWindow {

    public static void startwindow(){
        JFrame frame = new JFrame("Hello, java");
        frame.setSize(300, 150);
        JLabel label = new JLabel("Hello, Java!", JLabel.CENTER);
        frame.add(label);
        frame.setVisible(true);
    }

}
