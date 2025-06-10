package aut.ap.graphic.userEnvironment;

import aut.ap.graphic.userEnvironment.Views.AllEmails;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewWindow {

    public static void ShowEmail(JFrame preframe) {

        JFrame frame = new JFrame("Email Viewer");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(Color.PINK);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.PINK);

        JButton allEmailsButton = new JButton("All emails");
        JButton unreadEmailsButton = new JButton("Unread emails");
        JButton sentEmailsButton = new JButton("Sent emails");
        JButton readByEmailCodeButton = new JButton("Read by Code");
        JButton backToMenuButton = new JButton("Back to Menu");

        Dimension buttonSize = new Dimension(250, 60);
        Font buttonFont = new Font("Arial", Font.BOLD, 20);

        configureButton(allEmailsButton, buttonSize, buttonFont);
        configureButton(unreadEmailsButton, buttonSize, buttonFont);
        configureButton(sentEmailsButton, buttonSize, buttonFont);
        configureButton(readByEmailCodeButton, buttonSize, buttonFont);
        configureButton(backToMenuButton, buttonSize, buttonFont);


        allEmailsButton.addActionListener(e -> System.out.println("All emails button clicked"));
        unreadEmailsButton.addActionListener(e -> System.out.println("Unread emails button clicked"));
        sentEmailsButton.addActionListener(e -> System.out.println("Sent emails button clicked"));
        readByEmailCodeButton.addActionListener(e -> System.out.println("Read by Code button clicked"));


        backToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                preframe.setVisible(true);
            }
        });

        allEmailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                AllEmails.ShowAllEmails();
            }
        });

        panel.add(allEmailsButton);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(unreadEmailsButton);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(sentEmailsButton);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(readByEmailCodeButton);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));
        panel.add(backToMenuButton);

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