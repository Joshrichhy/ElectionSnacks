package Services;

import Data.Models.Mail;
import dtos.requests.CreateMail;

public interface MailService {
    Mail save(CreateMail createMail);

    Object findMailwithEmailAddress(String emailAddress);
}
