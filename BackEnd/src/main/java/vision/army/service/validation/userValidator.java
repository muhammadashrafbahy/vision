package vision.army.service.validation;

import vision.army.reprositery.userRepository;
import vision.army.entity.*;
import vision.army.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class userValidator {

    private userRepository userRepository;
    @Autowired
    public userValidator(userRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * returns a valid user the database
     * @param userID the given user
     * @return the user object
     */

    public user getValidUser(int userID) {

        user user = this.userRepository.findById(userID).orElse(null);
        if (user == null){

            throw new userNotFound(userID);
        }else {

            return user;
        }
    }

    /**
     * return true if  user already exist in the database
     * @param userName the given user
     * @return true or false
     */

    public boolean checkExistOfUserForCreation(String userName) {
        user user = this.userRepository.findByuserName(userName).orElse(null);
        if (user == null){

            return false;
        }else {

            throw new userAlreadyExist(userName);
        }
    }
}
