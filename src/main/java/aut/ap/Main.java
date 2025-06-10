package aut.ap;
import aut.ap.graphic.PopUpWindow;
import aut.ap.graphic.StartWindow;
import aut.ap.graphic.userEnvironment.MenuWindow;
import aut.ap.model.EmailRecipient;
import aut.ap.model.Email;
import aut.ap.model.User;
import aut.ap.service.GetUserService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import static aut.ap.graphic.PopUpWindow.pupUp;

public class Main {
        private static org.hibernate.SessionFactory sessionFactory;

        private static void setUpSessionFactory() {
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
        }

        private static void closeSessionFactory() {
            sessionFactory.close();
        }


        public static void main(String[] args) {


            User user = GetUserService.getUser("Mojiri");
            User recipientUser = GetUserService.getUser("Mokhtari");
            Email email = new Email(user, "first", "try here");
            EmailRecipient emailRecipient = new EmailRecipient(email, recipientUser);


            try {
                setUpSessionFactory();
                Session session = sessionFactory.openSession();
                Transaction tx = session.beginTransaction();
                session.persist(email);
                session.persist(emailRecipient);
                tx.commit();
                pupUp("Email send succesfully");
            } catch (Exception e) {
                String errorMassage = e.getMessage();
                pupUp(errorMassage);
            } finally {
                closeSessionFactory();
            }


        }
}