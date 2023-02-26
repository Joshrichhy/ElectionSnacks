package Services;

import Data.Models.User;
import Data.Repositories.UserRepository;
import Data.Repositories.UserRepositoryImpl;
import dtos.requests.RegisterRequest;
import dtos.responses.FindUserResponse;
import utils.Mapper;

public class UserServiceImpl implements UserService{
    private UserRepository userRepository = new UserRepositoryImpl();


    @Override
    public User register(RegisterRequest registerRequest) {
        if (userExist(registerRequest.getEmailAddress())){ throw new IllegalArgumentException(registerRequest.getEmailAddress() + " already exist");}
        return userRepository.save(Mapper.map(registerRequest));
    }

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public FindUserResponse findByEmailAddress(String emailAddress) {
        User foundUser = userRepository.findbyEmailAddress(emailAddress);
        FindUserResponse response = new FindUserResponse();
        Mapper.map(foundUser, response);
        return response;
    }

    @Override
    public void deleteByEmailAddress(String emailAddress) {
        userRepository.deleteWithEmailAddress(emailAddress);
    }

    private boolean userExist(String emailAddress) {
        User foundUser = userRepository.findbyEmailAddress(emailAddress);
        return foundUser != null;
    }
    public FindUserResponse findUser(int id) {
        User foundUser =  userRepository.findById(id);
        FindUserResponse response = new FindUserResponse();
        Mapper.map(foundUser, response);
        return response;
    }
}
