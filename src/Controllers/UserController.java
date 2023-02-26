package Controllers;

import Data.Models.User;
import Services.UserService;
import Services.UserServiceImpl;
import dtos.requests.RegisterRequest;

public class UserController {
    private UserService userService = new UserServiceImpl();

    public Object register(RegisterRequest registerRequest) {
        try {return userService.register(registerRequest);
        } catch (IllegalArgumentException e) {return e.getMessage();}
    }
    public Object findByMailAddress(String emailAddress) {
        try {
            return userService.findByEmailAddress(emailAddress);
        } catch (IllegalArgumentException e) {return e.getMessage();}
    }

    public long countUsers() {
        return userService.count(); }

    public void deleteUserWithEmailAddress(String emailAddress){
        userService.deleteByEmailAddress(emailAddress);
    }

    public Object findUserById(int id) {
        try {
            return userService.findUser(id);
        } catch (NullPointerException ex) {
            return  ex.getMessage();}
    }
}
