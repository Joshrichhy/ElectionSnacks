package Services;

import Data.Models.Mail;
import Data.Repositories.MailRepository;
import Data.Repositories.MailRepositoryImpl;
import dtos.requests.CreateMail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailServiceImplTest {
MailService mailService;
    CreateMail createMail;

    @BeforeEach
    void setUp() {
mailService = new MailServiceImpl();
        createMail = new CreateMail();
        createMail.setSubject("Subject");
        createMail.setMessage("Message");
        createMail.setEmailAddress("EmailAddress");
    }

    @Test
    public void saveOneMail(){
    Mail savedMail = mailService.save(createMail);
    assertEquals(1, savedMail.getMailId());
    }
    @Test
    public void saveOneMail_findMailWithAddress(){
        Mail savedMail = mailService.save(createMail);
        assertEquals(savedMail,mailService.findMailwithEmailAddress("EmailAddress"));
    }


}