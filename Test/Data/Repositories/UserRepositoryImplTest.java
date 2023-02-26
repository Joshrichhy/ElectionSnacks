package Data.Repositories;

import Data.Models.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {

    private UserRepository userRepository;
    private User user;
    User savedUser;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        userRepository = new UserRepositoryImpl();
        user = new User();
        user.setFirstName("Joshua");
        user.setLastName("Oluwakuse");
        user.setPassword("oluwatosin");
        user.setEmailAddress("kusejoshua@gmail.com");
        // savedUser = userRepository.save(user);

            }
    @Test
    public void registerUser_countIsOneTest(){
       userRepository.save(user);
        assertEquals(1, userRepository.count());}

    @Test
    public void registerUser_UserIdIsOneTest(){
       User savedUser = userRepository.save(user);
        assertEquals(1, savedUser.getUserId());}

    @Test
    public void registerUser_findUserWithUsername(){
        User savedUser = userRepository.save(user);
        assertEquals(savedUser, userRepository.findbyEmailAddress("kusejoshua@gmail.com")); }

    @Test
    public void saveUserTwiceWithSameId_userIdIsOne(){
        User savedUser = userRepository.save(user);
        assertEquals(1, savedUser.getUserId());
        savedUser.setFirstName("Jeremiah");
        User updateSavedUser = userRepository.save(savedUser);
        assertEquals(1, updateSavedUser.getUserId());

    }



    @Test
    public void saveTwoUsers_countIsTwo(){
      User  user2 = new User();
     userRepository.save(user);
      userRepository.save(user2);
      assertEquals(2, userRepository.count());
    }

    @Test
    public void saveTwoUsers_findAllUsers(){
         userRepository.save(user);
        User  user2 = new User();
        user2.setFirstName("Jeremiah");
        user2.setEmailAddress("h");
        userRepository.save(user2);
        List<User> allUser = new ArrayList<>();
       allUser.add(user);
       allUser.add(user2);
        System.out.println(userRepository.findbyEmailAddress("h").toString());
        System.out.println(user2.getUserId());
        System.out.println(allUser.toString());
        //System.out.println(userRepository.findAllUsers());
        assertEquals(allUser, userRepository.findAllUsers());
    }

    @Test
    public void saveOneUsers_deleteOneUserWithEmailAddress(){
        userRepository.save(user);
       userRepository.deleteWithEmailAddress("kusejoshua@gmail.com");
       assertEquals(0, userRepository.count());

    }
    @Test
    public void saveOneUsers_deleteOneUser(){
        userRepository.save(user);
        userRepository.deleteByUser(user);
        assertEquals(0, userRepository.count());
    }
    @Test
    public void deleteUserNotSavedThrowException(){

        assertThrows(IllegalArgumentException.class, ()-> userRepository.deleteByUser(user));
    }
}