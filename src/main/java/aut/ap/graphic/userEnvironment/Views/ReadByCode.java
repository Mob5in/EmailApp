package aut.ap.graphic.userEnvironment.Views;

import aut.ap.model.Email;
import aut.ap.service.GetEmailsService;
import aut.ap.service.GetQueryService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static aut.ap.service.SignUpService.register;

public class ReadByCode {

    public static void gettingCode(){
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
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
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
        String query = "FROM Email WHERE code = :" + code;
        List<Email> unreadEmail = GetQueryService.getQuery(query);



        JPanel emailListPanel = new JPanel();
        emailListPanel.setLayout(new BoxLayout(emailListPanel, BoxLayout.Y_AXIS));
        emailListPanel.setBackground(Color.WHITE);
        emailListPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        if (unreadEmail.isEmpty()) {
            JLabel emptyLabel = new JLabel("There is no email");
            emptyLabel.setFont(new Font("Arial", Font.ITALIC, 14));
            emptyLabel.setForeground(Color.GRAY);
            emptyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            emailListPanel.add(emptyLabel);
        } else {
            for (Email email : unreadEmail) {
                JPanel emailPanel = new JPanel();
                emailPanel.setLayout(new GridLayout(3, 1));
                emailPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                emailPanel.setBackground(Color.WHITE);

                JLabel senderLabel = new JLabel("Sender: " + email.getSender().getName());
                JLabel subjectLabel = new JLabel("Subject: " + email.getSubject() + "---> Code" + email.getCode());
                JLabel dateLabel = new JLabel("Date: " + email.getSentDate());
                JLabel bodyLabel = new JLabel("Massage : " + email.getBody() );

                emailPanel.add(senderLabel);
                emailPanel.add(subjectLabel);
                emailPanel.add(dateLabel);
                emailPanel.add(bodyLabel);

                emailListPanel.add(emailPanel);
                emailListPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            }
        }

        JScrollPane scrollPane = new JScrollPane(emailListPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
