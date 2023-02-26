import Controllers.MailController;
import Controllers.UserController;
import dtos.requests.CreateMail;
import dtos.requests.RegisterRequest;

import javax.swing.*;

public class Main {
    private static UserController userController = new UserController();
    private static MailController mailController = new MailController();
    public static void main(String[] args) {

            try{startApp();}
            catch (StringIndexOutOfBoundsException e){
                display("invalid input, try again");
                startApp();
            }
        }
        private static void startApp() {
            String message = """
                Welcome to your Email Application
                1 --> Register
                 2--> Find User
                 3--> Find User with ID
                 4--> Compose Mail
                 5 --> Find Mail with emailAddress
                 6 --> Read All mailss
                 """;
            String input = input(message);
            switch ((input.charAt(0))) {
                case '1' -> register();
                case '2' -> findUser();
                case '3' -> findUserByID();
                case '4' -> ComposeMail();
                case '5' -> findMailWithEmailAddress();
                //case '6' -> readAllPosts();
                default -> {
                    display("Invalid input, try again");
                    startApp();
                }
            }
    }

    private static void findMailWithEmailAddress() {
     String userinput = input("Recipient Email Address");
     display(mailController.findMail(userinput).toString());
    }

    private static void ComposeMail() {
        CreateMail mail = new CreateMail();
       mail.setSubject(input("Enter Mail Subject"));
       mail.setMessage(input("Write mail"));
       mail.setEmailAddress(input("Recipient Email Address"));
       display(mailController.saveMail(mail).toString());
       startApp();



    }

    private static void findUserByID() {
        String userInput = input("Enter User ID to search for");
        display(userController.findUserById(Integer.parseInt(userInput)).toString());
        startApp();
    }

    private static void register() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName(input("Enter First Name"));
        registerRequest.setLastName(input("Enter Last Name"));
        registerRequest.setEmailAddress(input("Enter Email Address"));
        registerRequest.setPassword(input("Enter Password"));
        var result = userController.register(registerRequest);
        display(result.toString());
        startApp();
    }
    private static void findUser() {
        String userInput = input("Enter Email Address to search for");
        display(userController.findByMailAddress(userInput).toString());
        startApp();

    }
    private static String input(String prompt) {
        return JOptionPane.showInputDialog(prompt);
    }

    private static void display(String message){
        JOptionPane.showMessageDialog(null, message);
    }



}