package Lab6.ConectionToDatabase;

import Lab6.Logger.Loggers;

import java.sql.*;

public class ConectionDatabase {
    private Loggers log = new Loggers();
    private final static String URL =
            "jdbc:postgresql:trains";

    private static final String USERNAME ="postgres";
    private static final String PASSWORD ="admin";

    private Connection connection;

    public ConectionDatabase(){
        try {

            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

        } catch (SQLException e) {
            log.LogErorr("Невдалося з'єднатися з БД!");
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        return connection;
    }
}
