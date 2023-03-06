package come.step.dubinin.dao;

import org.h2.engine.User;

import java.util.Optional;

public interface UserDAO {
   void createNewUser (User user);
   Optional<User> getUserByName (String userName);
}
