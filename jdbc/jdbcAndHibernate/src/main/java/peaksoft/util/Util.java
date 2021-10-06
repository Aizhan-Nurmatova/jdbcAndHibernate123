package peaksoft.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import peaksoft.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {

    // реализуйте настройку соеденения с БД

    public static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "jana1996"
            );
            System.out.println("Success");
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
        return connection;
    }


private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
                settings.put(Environment.USER, "postgres");
                settings.put(Environment.PASS, "jana1996");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");
                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "create");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(User.class);

                ServiceRegistry registry = new StandardServiceRegistryBuilder()
                        .applySettings(settings).build();
                sessionFactory = configuration.buildSessionFactory(registry);
                System.out.println("Connected");

            } catch (HibernateException e) {
                System.out.println(e.getMessage());
            }
        }
        return sessionFactory;
    }


    public static void shutDown() {
        getSessionFactory().close();
    }

}
