package aut.ap.service;

import aut.ap.graphic.userEnvironment.Menu;
import aut.ap.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static aut.ap.graphic.PopUp.pupUp;

public class LoginService {
    private static SessionFactory sessionFactory;


    private static void setUpSessionFactory() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    private static void closeSessionFactory() {
        sessionFactory.close();
    }

    public static void login(String email, String password) {
        setUpSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            User user = session.createQuery("FROM User WHERE email = :email", User.class)
                    .setParameter("email", email)
                    .uniqueResult();

            if (user == null) {
                pupUp("Doesn't exist!");
            } else if (user.getPassword().equals(password)) {
                pupUp("Welcome, " + user.getName());
                Menu.showMenu();
            } else {
                pupUp("Password is incorrect!");
            }
        } catch (Exception e) {
            pupUp("Error during login: " + e.getMessage());
        } finally {
            closeSessionFactory();
        }
    }
}
