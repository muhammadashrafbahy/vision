package vision.army.service.authorization;



import vision.army.reprositery.userRepository;
import vision.army.entity.*;
import vision.army.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private userRepository userRepository;

    public CustomUserDetailsService(userRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<user> user = userRepository.findByuserName(username);
        customerUserDetails customerUserDetails ;
        if(user.orElse(null) == null){
            System.out.println(username+" is not found");
            throw new UsernameNotFoundException("Invalid username or password.");


        }

else {
            customerUserDetails = user.map(customerUserDetails::new).get();
            System.out.println("username -" + customerUserDetails.getUsername());
            System.out.println("password -" + customerUserDetails.getPassword());
        }
        return customerUserDetails;
    }
}