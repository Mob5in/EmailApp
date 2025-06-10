package aut.ap.graphic.userEnvironment.Views;
import aut.ap.model.Email;
import aut.ap.service.GetEmailsService;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AllEmails {

    public static void ShowAllEmails() {
        JFrame frame = new JFrame("All Emails - Milou");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.PINK);

        List<Email> allEmails = GetEmailsService.getEmailsForUser();


        JPanel emailListPanel = new JPanel();
        emailListPanel.setLayout(new BoxLayout(emailListPanel, BoxLayout.Y_AXIS));
        emailListPanel.setBackground(Color.WHITE);
        emailListPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        if (allEmails.isEmpty()) {
            JLabel emptyLabel = new JLabel("There is no email");
            emptyLabel.setFont(new Font("Arial", Font.ITALIC, 14));
            emptyLabel.setForeground(Color.GRAY);
            emptyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            emailListPanel.add(emptyLabel);
        } else {
            for (Email email : allEmails) {
                JPanel emailPanel = new JPanel();
                emailPanel.setLayout(new GridLayout(3, 1));
                emailPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                emailPanel.setBackground(Color.WHITE);

                JLabel senderLabel = new JLabel("Sender: " + email.getSender().getName());
                JLabel subjectLabel = new JLabel("Subject: " + email.getSubject());
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