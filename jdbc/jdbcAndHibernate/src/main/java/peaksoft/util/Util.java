package peaksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
}
