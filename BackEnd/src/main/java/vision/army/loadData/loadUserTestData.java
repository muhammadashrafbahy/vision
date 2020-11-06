package vision.army.loadData;

import vision.army.reprositery.*;
import vision.army.entity.*;
import vision.army.exception.*;
import vision.army.service.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.commons.lang3.BooleanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Component
@Profile("dev")
public class loadUserTestData {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final userService userService ;
    private final ObjectMapper objectMapper ;

    public loadUserTestData(userService userService) {

        this.userService = userService;
        this.objectMapper =new ObjectMapper();

    }

    public void load() throws Exception{
        loadEmployees("classpath:data/user.json");

    }
    public void loadEmployees(String path) throws IOException {
        File file = ResourceUtils.getFile(path);
        byte[] fileContent = Files.readAllBytes(file.toPath());
        JsonNode rootNode = objectMapper.readTree(fileContent);
        rootNode.forEach(user -> {

            log.debug("Loading user json: {}", user);
            user entity = parseJSON(user);

            userService.createAnUser(entity);
            });
    }


    public user parseJSON(JsonNode jsonNode){
        user node = new user();

        node.setFullName(jsonNode.get("fullName").asText());
        node.setUserName(jsonNode.get("userName").asText());
        node.setPassword(jsonNode.get("password").asText());
        node.setUserEmail(jsonNode.get("userEmail").asText());
        node.setPrivilegeN(jsonNode.get("privilegeN").asInt());
        node.setImage(jsonNode.get("image").asText());
        return node;
    }
    public String BcryptEncode(String password){
            return  new BCryptPasswordEncoder().encode(password);
    }


    private void clearData() {
        try {
            userService.deleteALlUsers();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @PostConstruct
    public void init() throws Exception {
        System.out.println("****************LOAD DATA*******************");
//        boolean loadData = BooleanUtils.toBoolean(System.getProperty("loadData"));
//        if (loadData) {
//
//
//        }else{


            clearData();
            load();
//        }
    }

    }
