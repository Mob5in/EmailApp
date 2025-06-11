package aut.ap.graphic.userEnvironment;

import aut.ap.graphic.PopUpWindow;
import aut.ap.model.Email;
import aut.ap.service.GetByCode;
import aut.ap.service.SendService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReplyWindow{

    public static void gettingCodeAndBody() {
        JFrame frame = new JFrame("Enter Code & Name - Milou");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(Color.WHITE);

        JLabel codeLabel = new JLabel("Code:");
        JTextField codeField = new JTextField();
        codeField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        JLabel BodyLabel = new JLabel("Body:");
        JTextField bodyField = new JTextField();
        bodyField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));


        JButton submitButton = new JButton("Submit");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.setMaximumSize(new Dimension(150, 40));

        panel.add(codeLabel);
        panel.add(codeField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(BodyLabel);
        panel.add(bodyField);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String code = codeField.getText().trim();
                String body = bodyField.getText().trim();

                if (code.isEmpty()) {
                    PopUpWindow.pupUp("Code cant be empty");
                    return;
                }

                if (code.length() != 6) {
                    PopUpWindow.pupUp("Code should be at least 6 char");
                    return;
                }

                if (body.isEmpty()) {
                    PopUpWindow.pupUp("body canot be empty");
                    return;
                }
                Email orgEmail = GetByCode.getCode(code);
                SendService.sendEmail("[RP] "+orgEmail.getSubject(), orgEmail.getSender().getEmail() ,  body);
                frame.dispose();

            }
        });


        frame.add(panel);
        frame.setVisible(true);
    }
}