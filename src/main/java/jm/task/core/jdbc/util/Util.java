package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

public class Util {
    //JDBC
    public static Connection getConnection() {
        Connection connection = null;
        String dbURL = "jdbc:mysql://localhost:3306/schema1_1_3?useSSL=false";
        String dbUsername = "root";
        String dbPassword = "root";
        try {
            connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //Hibernate
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration()
                        .setProperty("hibernate.connection.dialect",
                                "org.hibernate.dialect.MySQL5Dialect")
                        .setProperty("hibernate.connection.driver_class",
                                "com.mysql.jdbc.Driver")
                        .setProperty("hibernate.connection.username",
                                "root")
                        .setProperty("hibernate.connection.password",
                                "root")
                        .setProperty("hibernate.connection.url",
                                "jdbc:mysql://localhost:3306/schema1_1_3?useSSL=false")
                        .addAnnotatedClass(User.class);
                sessionFactory = configuration.buildSessionFactory();
            } catch (Throwable ex) {
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory;
    }
}
