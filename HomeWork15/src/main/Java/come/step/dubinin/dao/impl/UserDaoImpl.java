package come.step.dubinin.dao.impl;

import come.step.dubinin.confige.Connector;
import come.step.dubinin.dao.UserDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.taglibs.standard.lang.jstl.Logger;
import org.h2.engine.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDaoImpl implements UserDAO {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(UserDaoImpl.class);

    @Override
    public void createNewUser(User user) {
        try (Connection connection = Connector.createConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("INSERT INTO USERS (username, password)")) {
                ps.setString(1, user.getName());
                ps.setString(2, user.getPassword());
                ps.executeUpdate();
            }


        } catch (SQLException tes) {
            LOGGER.error("SQLException in method getID" + tes);
        }

    }

    @Override
    public Optional<User> getUserByName(String userName) {
        Optional<User> optionalUser = Optional.empty();
        try (Connection connection = Connector.createConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("SELECT*FROM GOODS WHERE USERNAME ='" + userName
                    + "'")) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    optionalUser = Optional.of(
                            new User(rs.getLong("ID")),
                            rs.getString("USERNAME"),
                            rs.getString("PASSWORD"));


                }

            }


        } catch (SQLException tes) {
            LOGGER.error("SQLException in method getID" + tes);
        }
        return Optional.empty();
    }
}
