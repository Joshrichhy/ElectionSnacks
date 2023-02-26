package Data.Repositories;

import Data.Models.Mail;
import Data.Models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MailRepositoryImplTest {
    Mail mail ;
    MailRepository mailRepository;

    @BeforeEach
    void setUp(){
        mail = new Mail();
       mailRepository = new MailRepositoryImpl();
        mail.setSubject("Job Application");
        mail.setMessage("Software Engineering job is available");
        mail.setEmailAddress("paulineObibia@gmail.com");
    }

    @Test
    public void saveOneMail_countIsOne(){
        mailRepository.save(mail);
        assertEquals(1, mailRepository.count());    }

    @Test
    public void saveOneMail_countIdOne(){
       Mail savedMail =  mailRepository.save(mail);
        assertEquals(1, savedMail.getMailId());
    }
    @Test
    public void saveOneMail_getMail(){
        Mail savedMail = mailRepository.save(mail);
        assertEquals(savedMail, mailRepository.findbyMail(mail));
    }
    @Test
    public void saveTwoMails_countMails(){
        Mail mail2 = new Mail();
        mailRepository.save(mail);
        mailRepository.save(mail2);
        assertEquals(2, mailRepository.count());
    }

    @Test
    public void saveOneMail_findmailbyEmailAddress(){
        mailRepository.save(mail);
        assertEquals(mail, mailRepository.findbyEmailAddress("paulineObibia@gmail.com"));
    }

    @Test
    public void saveTwoMail_findAllmail(){
        mailRepository.save(mail);
        Mail mail2 = new Mail();
        mailRepository.save(mail2);
        ArrayList<Mail> allMails = new ArrayList<>();
        allMails.add(mail);
        allMails.add(mail2);
        assertEquals(allMails, mailRepository.findAllUsers());
    }






}