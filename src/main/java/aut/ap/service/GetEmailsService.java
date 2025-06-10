package aut.ap.service;

import aut.ap.graphic.userEnvironment.MenuWindow;
import aut.ap.model.Email;
import aut.ap.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.ArrayList;
import java.util.List;



public class GetEmailsService {

    private static SessionFactory sessionFactory;

    private static void setUpSessionFactory() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    private static void closeSessionFactory() {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }

    public static List<Email> getEmailsForUser() {
        setUpSessionFactory();
        Session session = sessionFactory.openSession();

        User currentUser = MenuWindow.getCorrentUser();
        List<Email> allEmails = new ArrayList<>();

        try {
            String sentQuery = "FROM Email WHERE sender.id = :userId";
            List<Email> sentEmails = session.createQuery(sentQuery, Email.class)
                    .setParameter("userId", currentUser.getId())
                    .getResultList();

            String receivedQuery = "SELECT er.email FROM EmailRecipient er WHERE er.recipient.id = :userId";
            List<Email> receivedEmails = session.createQuery(receivedQuery, Email.class)
                    .setParameter("userId", currentUser.getId())
                    .getResultList();


            allEmails.addAll(sentEmails);
            allEmails.addAll(receivedEmails);


        } finally {
            session.close();
            closeSessionFactory();
        }

        return allEmails;
    }
}