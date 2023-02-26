package Controllers;

import Services.MailService;
import Services.MailServiceImpl;
import dtos.requests.CreateMail;

public class MailController {
    MailService mailService = new MailServiceImpl();

    public Object saveMail(CreateMail mail){
        try {
            return mailService.save(mail);
        }
        catch (NullPointerException e){ return "Email Addres not registered";}

    }

    public Object findMail(String emailAddress){
        return mailService.findMailwithEmailAddress(emailAddress);
    }
}
