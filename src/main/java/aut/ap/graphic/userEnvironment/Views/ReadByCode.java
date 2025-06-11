package aut.ap.graphic.userEnvironment.Views;

import aut.ap.model.Email;
import aut.ap.service.GetByCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReadByCode {

    public static void gettingCode() {
        JFrame frame = new JFrame("Enter Code - Milou");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(Color.WHITE);

        JLabel nameLabel = new JLabel("Code:");
        JTextField codeField = new JTextField();
        codeField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        JButton submitButton = new JButton("Submit");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.setMaximumSize(new Dimension(150, 40));

        panel.add(nameLabel);
        panel.add(codeField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String code = codeField.getText();
                frame.dispose();
                readByCode(code);
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void readByCode(String code) {
        JFrame frame = new JFrame("Email - Milou");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.PINK);
        frame.setLocationRelativeTo(null);

        Email email = GetByCode.getCode(code);

        JPanel emailListPanel = new JPanel();
        emailListPanel.setLayout(new BoxLayout(emailListPanel, BoxLayout.Y_AXIS));
        emailListPanel.setBackground(Color.WHITE);
        emailListPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        if (email == null) {
            JLabel emptyLabel = new JLabel("There is no email");
            emptyLabel.setFont(new Font("Arial", Font.ITALIC, 14));
            emptyLabel.setForeground(Color.GRAY);
            emptyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            emailListPanel.add(emptyLabel);
        } else {
            JPanel emailPanel = new JPanel();
            emailPanel.setLayout(new GridLayout(4, 1));
            emailPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            emailPanel.setBackground(Color.WHITE);

            JLabel senderLabel = new JLabel("Sender: " + email.getSender().getName());
            JLabel subjectLabel = new JLabel("Subject: " + email.getSubject() + " ---> Code: " + email.getCode());
            JLabel dateLabel = new JLabel("Date: " + email.getSentDate());

            JTextArea bodyArea = new JTextArea("Message: " + email.getBody());
            bodyArea.setWrapStyleWord(true);
            bodyArea.setLineWrap(true);
            bodyArea.setEditable(false);
            bodyArea.setBackground(Color.WHITE);
            bodyArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

            emailPanel.add(senderLabel);
            emailPanel.add(subjectLabel);
            emailPanel.add(dateLabel);
            emailPanel.add(bodyArea);

            emailListPanel.add(emailPanel);
            emailListPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        JScrollPane scrollPane = new JScrollPane(emailListPanel);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}