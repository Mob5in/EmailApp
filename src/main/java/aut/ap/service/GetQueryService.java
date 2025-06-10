package aut.ap.service;

import aut.ap.graphic.userEnvironment.MenuWindow;
import aut.ap.model.Email;
import aut.ap.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class GetQueryService {

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

    public static List<Email> getQuery(String query) {
        setUpSessionFactory();
        Session session = sessionFactory.openSession();

        User currentUser = MenuWindow.getCorrentUser();
        List<Email> allEmails = new ArrayList<>();

        try {;
            List<Email> receivedEmails = session.createQuery(query, Email.class)
                    .setParameter("userId", currentUser.getId())
                    .getResultList();

            allEmails.addAll(receivedEmails);


        } finally {
            session.close();
            closeSessionFactory();
        }

        return allEmails;
    }
}
