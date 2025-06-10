package aut.ap.service;
import aut.ap.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import static aut.ap.graphic.PopUp.pupUp;




public class SignUpService {
    private static org.hibernate.SessionFactory sessionFactory;
    private static void setUpSessionFactory() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    private static void closeSessionFactory() {
        sessionFactory.close();
    }

    public static void register(String name, String email, String password){
        try{
            System.out.println("hello");
            User user = new User(name, email, password);
            setUpSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.persist(user);
            tx.commit();
            pupUp("User created successfully");
        }catch (Exception e){
                String errorMassage = e.getMessage();
                pupUp(errorMassage);
        }finally {
            closeSessionFactory();
        }

    }


}
