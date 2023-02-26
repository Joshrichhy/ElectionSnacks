package Services;

import Data.Models.User;
import dtos.requests.RegisterRequest;
import dtos.responses.FindUserResponse;

public interface UserService {
    User register(RegisterRequest registerRequest);

    long count();

    FindUserResponse findByEmailAddress(String emailAddress);


    void deleteByEmailAddress(String emailAddress);

    Object findUser(int id);
}
