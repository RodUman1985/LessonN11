package come.step.dubinin.confige;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class ContextInitializer  implements ServletContextListener {
    private static final Logger LOGGER = LogManager.getLogger(ContextInitializer.class);
    private final String initUrl = PropertiesLoader.loadProperties("db.init");
    private final String user = PropertiesLoader.loadProperties("db.user");
    private final String password = PropertiesLoader.loadProperties("db.password");


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try (Connection connection = DriverManager.getConnection(initUrl, user, password)) {
        } catch (SQLException e) {
            LOGGER.error("SQLExseption on ContextInitializer");
        }
    }
}
