package aut.ap.service;

import aut.ap.model.EmailRecipient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class IsReadService {

    private static SessionFactory sessionFactory;


    private static void setUpSessionFactory() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    private static void closeSessionFactory() {
        sessionFactory.close();
    }


    public static boolean markEmailAsRead(String emailCode, int userId) {
        setUpSessionFactory();
        Session session = sessionFactory.openSession();
        boolean updated = false;

        try {
            session.beginTransaction();
            String hql = "FROM EmailRecipient WHERE email.code = :code AND recipient.id = :userId";
            EmailRecipient recipient = session.createQuery(hql, EmailRecipient.class)
                    .setParameter("code", emailCode)
                    .setParameter("userId", userId)
                    .uniqueResult();

            if (recipient != null && !recipient.isRead()) {
                recipient.setRead(true);
                session.update(recipient);
                updated = true;
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
            closeSessionFactory();
        }

        return updated;
    }
}
