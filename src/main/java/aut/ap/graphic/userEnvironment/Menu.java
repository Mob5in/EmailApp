package aut.ap.graphic.userEnvironment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu{

    public static void showMenu() {
        JFrame frame = new JFrame("User Menu");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(Color.PINK);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.PINK);


        JButton sendButton = new JButton("Send");
        JButton viewButton = new JButton("View");
        JButton replyButton = new JButton("Reply");
        JButton forwardButton = new JButton("Forward");

        Dimension buttonSize = new Dimension(250, 60);
        Font buttonFont = new Font("Arial", Font.BOLD, 20);

        configureButton(sendButton, buttonSize, buttonFont);
        configureButton(viewButton, buttonSize, buttonFont);
        configureButton(replyButton, buttonSize, buttonFont);
        configureButton(forwardButton, buttonSize, buttonFont);


        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Send button clicked");
            }
        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("View button clicked");
            }
        });

        replyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Reply button clicked");
            }
        });

        forwardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Forward button clicked");
            }
        });

        panel.add(sendButton);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(viewButton);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(replyButton);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(forwardButton);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    private static void configureButton(JButton button, Dimension size, Font font) {
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setPreferredSize(size);
        button.setMinimumSize(size);
        button.setMaximumSize(size);
        button.setFont(font);
        button.setBackground(Color.WHITE);
        button.setFocusPainted(false);
    }
}