package Services;

import Data.Models.Mail;
import Data.Models.User;
import Data.Repositories.MailRepository;
import Data.Repositories.MailRepositoryImpl;
import dtos.requests.CreateMail;
import dtos.responses.FindUserResponse;
import utils.Mapper;

public class MailServiceImpl implements MailService{
MailRepository mailRepository = new MailRepositoryImpl();
UserService userService = new UserServiceImpl();


    @Override
    public Mail save(CreateMail mailCreated) {
       FindUserResponse user = userService.findByEmailAddress(mailCreated.getEmailAddress());
       mailCreated.setEmailAddress(user.getEmailAddress());
        return mailRepository.save(Mapper.map(mailCreated));
    }

    @Override
    public Mail findMailwithEmailAddress(String emailAddress) {
        return mailRepository.findbyEmailAddress(emailAddress);
    }
}
