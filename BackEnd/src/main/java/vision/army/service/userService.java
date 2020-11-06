package vision.army.service;
import vision.army.reprositery.*;
import vision.army.entity.*;
import vision.army.exception.*;
import vision.army.service.validation.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {
    private userRepository userRepository ;
    private userValidator userValidator;
    private ModelMapper modelMapper;
    @Autowired
    public userService(userRepository userRepository) {
        this.userRepository = userRepository;
    }



    /**
     * return all users
     * @return a list of all users
     */

    public List<user> getAllUsers(){

        return userRepository.findAll();
    }

    /**
     * returns the details of a given user
     * @param userID the id of the user
     * @return user details
     */
    public user getAnUser(int userID){

            try {
                return  this.userValidator.getValidUser(userID);
            }catch (Exception e){
                throw new userNotFound(userID);
            }

    }

    /**
     * delete an user
     * @param userID the id of the user

     */
    public void deleteAnUser(int userID){

        try {
            user user = this.userValidator.getValidUser(userID);
            if (user!= null ){

                this.userRepository.delete(user);
            }
        }catch (Exception e){
            throw new userNotFound(userID);
        }

    }

    /**
     * update data in an user in the database
     * @param userID the id of the user to update
     * @param newUser the payload of the user to update

     */
    public void updateAnUser(int userID , user newUser){

        try {
            newUser.setUserID(userID);
            user oldUser = this.userValidator.getValidUser(userID);
            modelMapper.map(newUser ,oldUser);
            this.userRepository.save(oldUser);
        }catch (Exception e){
            throw new userNotFound(userID);
        }

    }

    /**
     * create new user in the database
     * @param newUser the payload of the user to update

     */
    public void createAnUser(user newUser){
            String enCodedPassword = new BCryptPasswordEncoder().encode(newUser.getPassword());
        newUser.setPassword(enCodedPassword);

          this.userRepository.save(newUser);


    }





    public void deleteALlUsers(){this.userRepository.deleteAll();}



}
