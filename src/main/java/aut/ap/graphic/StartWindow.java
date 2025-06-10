package aut.ap.graphic;

import aut.ap.graphic.entryEnviroment.LoginWindow;
import aut.ap.graphic.entryEnviroment.SignUpWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartWindow {

    public static void startwindow() {
        JFrame frame = new JFrame("Milou");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(Color.PINK);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.PINK);

        JButton loginButton = new JButton("Login");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setPreferredSize(new Dimension(200, 50));
        loginButton.setFont(new Font("Arial", Font.BOLD, 18));

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        signUpButton.setPreferredSize(new Dimension(200, 50));
        signUpButton.setFont(new Font("Arial", Font.BOLD, 18));



        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Login button clicked");
                loginButton.addActionListener(LoginWindow.login());

            }
        });

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Sign Up button clicked");
                signUpButton.addActionListener(SignUpWindow.signUp());
            }
        });

        panel.add(loginButton);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(signUpButton);

        frame.add(panel);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}