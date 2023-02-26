package Data.Repositories;

import Data.Models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserRepositoryImpl implements UserRepository{

    private static List <User> users = new ArrayList<>();
    private int count;

    @Override
    public User save(User user) {
        boolean userNotSavedYet = user.getUserId() == 0;
        if(userNotSavedYet){
            user.setUserId(generateId());
        users.add(user);
        count++;}
        return user;
    }

    private int generateId() {
        return count+1;
    }

    @Override
    public int count() {
        return count++;
    }

    @Override
    public User findbyEmailAddress(String emailAddress) {
        for (User user: users) {if(Objects.equals(user.getEmailAddress(), emailAddress))
            return user;}return null;}
     // throw new IllegalArgumentException("Email Address not found");  }
    @Override
    public List<User> findAllUsers() {
        return users;
    }

    @Override
    public User findByUser(User user) {
        for (User eachUser: users) {if(user == eachUser)return user;}
        throw new IllegalArgumentException("User not found");
    }

    @Override
    public void deleteWithEmailAddress(String emailAddress) {
        User deleteUser = findbyEmailAddress(emailAddress);
        users.remove(deleteUser);
        count--;
    }

    @Override
    public void deleteByUser(User user) {
        User deleteUser = findByUser(user);
        users.remove(deleteUser);
        count--;

    }

    public User findById(int userId) {
        for (User user : users) if (user.getUserId() == userId) return user;
        throw  new NullPointerException("User Id not found");
    }
}
