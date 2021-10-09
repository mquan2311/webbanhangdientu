/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Properties;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
/**
 *
 * @author memft
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
//                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/demo?useSSL=false");
                                settings.put(Environment.URL, "jdbc:mysql://61.14.233.11:3306/demo?useSSL=false");

                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "280700");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "update");

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(UserHBN.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
                 System.out.println("alo4");
                System.out.println("Hibernate Java Config serviceRegistry created");
                 System.out.println("alo5");
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                 System.out.println("alo3");
                return sessionFactory;

            } catch (Exception e) {
                
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
//     public static void main(String[] args) {
//         System.out.println("alo");
//          System.out.println("alo2");
//         System.out.println(getSessionFactory());
//        
//         Transaction transaction = null;
//         
//        UserHBN user = null;
//        
//        try (Session session = getSessionFactory().openSession()) {
//            // start a transaction
//            System.out.println("alo7");
//            transaction = session.beginTransaction();
//            // get an user object
//            System.out.println("alo6");
//            user = (UserHBN) session.createQuery("FROM users WHERE username = admin").uniqueResult();
//            
//            if (user != null) {
//                System.out.println("Co");
//            }
//            // commit transaction
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//            System.out.println("ko ket noi");;
//        }
//        System.out.println("Ko");
//    }
}
     
