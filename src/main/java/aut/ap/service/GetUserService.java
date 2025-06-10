package aut.ap.service;
import aut.ap.model.Email;
import aut.ap.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import static aut.ap.graphic.PopUpWindow.pupUp;

public class GetUserService {

    private static SessionFactory sessionFactory;


    private static void setUpSessionFactory() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    private static void closeSessionFactory() {
        sessionFactory.close();
    }

    public static User getUser(String email) {

        setUpSessionFactory();

        try (
                Session session = sessionFactory.openSession()) {
            User user = session.createQuery("FROM User WHERE email = :email", User.class)
                    .setParameter("email", email)
                    .uniqueResult();

            if (user == null) {
                pupUp("Doesn't exist such user\n" +
                        "email canot sent, try again!");
            } else {
                return user;
            }
        } catch (Exception e) {
            pupUp("Error during searching: " + e.getMessage());
        } finally {
            closeSessionFactory();
        }
        return null;
    }
}
