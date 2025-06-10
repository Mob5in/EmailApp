package aut.ap.service;

import aut.ap.graphic.PopUpWindow;
import aut.ap.graphic.userEnvironment.MenuWindow;
import aut.ap.model.EmailRecipient;
import aut.ap.model.Emails;
import aut.ap.model.User;
import org.hibernate.id.enhanced.PooledLoOptimizer;

public class SendService{

    public static void sendEmail(String subject, String recipient, String body){
        if(recipient.equals("")){
            PopUpWindow.pupUp("recipient canot be empty");
        }
        User user = MenuWindow.getCorrentUser();
        User userRecipient = GetUserService.getUser(recipient);
        Emails email = new Emails(user, subject, body);
        EmailRecipient emailRecipient = new EmailRecipient(email, userRecipient);

    }

}
