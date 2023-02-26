package Data.Repositories;

import Data.Models.Mail;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MailRepositoryImpl  implements MailRepository{
private int count;
List <Mail> mails = new ArrayList<>();

    @Override
    public Mail save(Mail mail) {
        count++;
        mail.setMailId(generateId());
        mails.add(mail);

        return mail;
    }

    private int generateId() {
        return count;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public Mail findbyMail(Mail mail) {
        for (Mail eachMail: mails) {if (eachMail == mail) return mail;}
        throw new NullPointerException("Mail Not Found");
    }

    @Override
    public Mail findbyEmailAddress(String emailAddress) {
        for (Mail eachMail: mails) {if (Objects.equals(eachMail.getEmailAddress(), emailAddress)) return eachMail;}
        throw new NullPointerException("Mail Not Found");
    }

    @Override
    public void deleteByMail(Mail email) {

    }

    @Override
    public List<Mail> findAllUsers() {
        return mails;
    }
}
