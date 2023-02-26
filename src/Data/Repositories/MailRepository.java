package Data.Repositories;

import Data.Models.Mail;

import java.util.ArrayList;
import java.util.List;

public interface MailRepository {
    Mail save(Mail mail);

    int count();

    Mail findbyMail(Mail mail);

    Mail findbyEmailAddress(String emailAddress);

    void deleteByMail(Mail email);

    List<Mail> findAllUsers();
}
