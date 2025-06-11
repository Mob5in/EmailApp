package aut.ap.service;
import aut.ap.graphic.PopUpWindow;
import aut.ap.graphic.userEnvironment.MenuWindow;
import aut.ap.model.EmailRecipient;
import aut.ap.model.Email;
import aut.ap.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import static aut.ap.graphic.PopUpWindow.pupUp;

public class SendService{

    private static org.hibernate.SessionFactory sessionFactory;
    private static void setUpSessionFactory() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    private static void closeSessionFactory() {
        sessionFactory.close();
    }


    public static void sendEmail(String subject, String recipient, String body){
        if(recipient.isEmpty()){
            PopUpWindow.pupUp("recipient canot be empty");
            return;
        }
        User user = MenuWindow.getCorrentUser();
        User recipientUser = GetUserService.getUser(recipient);
        Email email = new Email(user, subject, body);
        EmailRecipient emailRecipient = new EmailRecipient(email, recipientUser);

        if (recipientUser == null) {
            PopUpWindow.pupUp("Recipient not found");
            return;
        }


        try{
            setUpSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.persist(email);
            session.persist(emailRecipient);
            tx.commit();
            pupUp("Email send successfully");
        }catch (Exception e){
            String errorMassage = e.getMessage();
            pupUp(errorMassage);
        }finally {
            closeSessionFactory();
        }

    }

}
