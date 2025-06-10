package aut.ap.graphic.userEnvironment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View {

    public static void ShowEmail(JFrame preFrame) {

        preFrame.setVisible(false);

        JFrame frame = new JFrame("Email Viewer");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(Color.PINK);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.PINK);

        // تعریف دکمه‌ها با اسم‌های جدید
        JButton allEmailsButton = new JButton("All emails");
        JButton unreadEmailsButton = new JButton("Unread emails");
        JButton sentEmailsButton = new JButton("Sent emails");
        JButton readByEmailCodeButton = new JButton("Read by Code");

        Dimension buttonSize = new Dimension(250, 60);
        Font buttonFont = new Font("Arial", Font.BOLD, 20);

        // تنظیمات دکمه‌ها
        configureButton(allEmailsButton, buttonSize, buttonFont);
        configureButton(unreadEmailsButton, buttonSize, buttonFont);
        configureButton(sentEmailsButton, buttonSize, buttonFont);
        configureButton(readByEmailCodeButton, buttonSize, buttonFont);

        // عملکرد دکمه‌ها
        allEmailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("All emails button clicked");
                // مثلاً: EmailManager.showAllEmails();
            }
        });

        unreadEmailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Unread emails button clicked");
                // مثلاً: EmailManager.showUnreadEmails();
            }
        });

        sentEmailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Sent emails button clicked");
                // مثلاً: EmailManager.showSentEmails();
            }
        });

        readByEmailCodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Read by Code button clicked");
                // مثلاً: EmailManager.showEmailByCode();
            }
        });

        // اضافه کردن دکمه‌ها به پنل
        panel.add(allEmailsButton);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(unreadEmailsButton);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(sentEmailsButton);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(readByEmailCodeButton);

        frame.add(panel);
        frame.setLocationRelativeTo(null); // مرکز صفحه
        frame.setVisible(true);
    }

    // تنظیمات مشترک برای دکمه‌ها
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