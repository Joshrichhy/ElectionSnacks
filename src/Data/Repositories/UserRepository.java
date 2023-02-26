package Data.Repositories;

import Data.Models.User;

import java.util.List;

public interface UserRepository {
     User save(User user);

    int count();

    User findbyEmailAddress(String emailAddress);


    List<User> findAllUsers();
   User findByUser(User user);

    void deleteWithEmailAddress(String emailAddress);

    void deleteByUser(User user);

    public User findById(int userId);

}
