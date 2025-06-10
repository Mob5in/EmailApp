package aut.ap.graphic.userEnvironment;

import aut.ap.service.SendService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendWindow {

    public static void send() {
        JFrame frame = new JFrame("Send Email - Milou");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(Color.WHITE);

        JLabel recipientLabel = new JLabel("Recipient:");
        JTextField recipientField = new JTextField();
        recipientField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));


        JLabel subjectLabel = new JLabel("Subject:");
        JTextField subjectField = new JTextField();
        subjectField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));


        JLabel bodyLabel = new JLabel("Body:");
        JTextArea bodyArea = new JTextArea();
        bodyArea.setRows(5);
        bodyArea.setLineWrap(true);
        bodyArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(bodyArea);
        scrollPane.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));


        JButton sendButton = new JButton("Send");
        sendButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        sendButton.setMaximumSize(new Dimension(150, 40));


        panel.add(recipientLabel);
        panel.add(recipientField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(subjectLabel);
        panel.add(subjectField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(bodyLabel);
        panel.add(scrollPane);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        panel.add(sendButton);


        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String recipient = recipientField.getText().trim();
                String subject = subjectField.getText().trim();
                String body = bodyArea.getText().trim();

                System.out.println("Recipient: " + recipient);
                System.out.println("Subject: " + subject);
                System.out.println("Body: " + body);
                SendService.sendEmail(subject, recipient, body);


            }
        });

        frame.add(panel);
        frame.setVisible(true);

    }
}