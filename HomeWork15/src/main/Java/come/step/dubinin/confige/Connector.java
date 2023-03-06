package come.step.dubinin.confige;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Connector {
    private static final String URL = PropertiesLoader.loadProperties("db.url");
    private static final String USER = PropertiesLoader.loadProperties("db.user");
    private static final String PASSWORD = PropertiesLoader.loadProperties("db.password");

    private Connector(){

    }

    public static Connection createConnection() throws SQLException {
       return DriverManager.getConnection(URL,USER,PASSWORD);
    };
}
