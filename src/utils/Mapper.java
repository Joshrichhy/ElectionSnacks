package utils;

import Data.Models.Mail;
import Data.Models.User;
import dtos.requests.CreateMail;
import dtos.requests.RegisterRequest;
import dtos.responses.FindUserResponse;

import java.time.format.DateTimeFormatter;

public class Mapper {
    public static User map(RegisterRequest registerRequest){
        User user = new User();
        user.setEmailAddress(registerRequest.getEmailAddress());
        user.setPassword(registerRequest.getPassword());
        user.setLastName(registerRequest.getLastName());
        user.setFirstName(registerRequest.getFirstName());
        return user;
    }

    public static void map(User foundUser, FindUserResponse response){

        response.setFullName(foundUser.getFirstName() + " " + foundUser.getLastName());
        response.setEmailAddress(foundUser.getEmailAddress());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd/MM/yyyy, hh:mm a");
        response.setDateRegistered(formatter.format(foundUser.getDateCreated()));
    }

    public static Mail map(CreateMail mailcreated){
      Mail mail = new Mail();
        mail.setEmailAddress(mailcreated.getEmailAddress());
        mail.setSubject(mailcreated.getSubject());
        mail.setMessage(mailcreated.getMessage());
        mail.setTime(mailcreated.getTime());
        return mail;
    }
}
