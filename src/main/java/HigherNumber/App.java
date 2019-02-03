package HigherNumber;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Iterator;
import java.util.List;

@SpringBootApplication
public class App {
    private static SessionFactory factory;


    public static void main(String[] args) throws InterruptedException {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }


        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List users = session.createQuery("FROM Trx").list();
            System.out.println(users.size());
            for (Iterator iterator = users.iterator(); iterator.hasNext(); ) {
                Trx user = (Trx) iterator.next();
                System.out.println("First Name: " + user.getAbc());
            }
            try {
                Thread.sleep(20000);
            } catch (Exception e) {

            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                Thread.sleep(20000);
            } catch (Exception e) {

            }
            session.close();
        }

        SpringApplication.run(App.class, args);
    }
}
