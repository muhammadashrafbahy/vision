package vision.army.v1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/vision/facebook")
public class FacebookController  {

//    private Facebook facebook = new 0;

//    private ConnectionRepository connectionRepository;


    //    @Autowired
    //    public FacebookController(Facebook facebook, ConnectionRepository connectionRepository) {
    //        this.facebook = facebook;
    //        this.connectionRepository = connectionRepository;
    //    }

    @GetMapping("/")
    public String  welcome(Principal principal) {
        return "redirect:/connect/facebook";
    }
}
