package Services;

import Data.Models.User;
import dtos.requests.RegisterRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    UserService userService;
    User user;
    RegisterRequest registerRequest;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl();
        registerRequest = new RegisterRequest();
       user = new User();
       registerRequest.setFirstName("Joshua");
       registerRequest.setEmailAddress("Oluwakuse");
       registerRequest.setEmailAddress("kusejoshua@gmail.com");
       registerRequest.setPassword("password");
    }
    @Test
    public void registerUser_idIsNotZero(){
      User user =  userService.register(registerRequest);
        System.out.println(user);
        assertEquals(1, user.getUserId());
    }
    @Test
    public void registerTwoUsers_emailNotSame(){
        userService.register(registerRequest);

        assertThrows(IllegalArgumentException.class, ()->  userService.register(registerRequest));
    }
    @Test
    public void test_findUserByEmailAddress(){
        User user = userService.register(registerRequest);
        assertEquals(registerRequest, userService.findByEmailAddress("kusejoshua@gmail.com"));
    }

    @Test
    public void test_findUserByEmailAddressAndDelete(){
        userService.register(registerRequest);
        userService.deleteByEmailAddress("kusejoshua@gmail.com");
        assertEquals(0, userService.count());
    }
    @Test
    public void test_updateUserIdNotChanged(){
        User savedUser = userService.register(registerRequest);
        savedUser.setFirstName("Ayomide");
        assertEquals(1, savedUser.getUserId());
    }

    @Test
    public void printbyEmail(){
        userService.register(registerRequest);
        System.out.println(userService.findByEmailAddress("kusejoshua@gmail.com"));
    }




}