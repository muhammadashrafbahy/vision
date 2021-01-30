package vision.army.loadData;

import vision.army.entity.*;
import vision.army.service.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.commons.lang3.BooleanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
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
    private final productService productService ;
    private final clientService clientService;
    private final ObjectMapper objectMapper ;
    private final brandService brandService;

    public loadUserTestData( brandService brandService,userService userService ,productService productService ,clientService clientService) {
        this.clientService= clientService;
        this.userService = userService;
        this.productService = productService;
        this. brandService= brandService;
        this.objectMapper =new ObjectMapper();

    }

    public void load() throws Exception{
        loadEmployees("classpath:data/user.json");
        loadProduct("classpath:data/product.json");
        loadClient("classpath:data/client.json");

    }
    public void loadEmployees(String path) throws IOException {
        File file = ResourceUtils.getFile(path);
        byte[] fileContent = Files.readAllBytes(file.toPath());
        JsonNode rootNode = objectMapper.readTree(fileContent);
        rootNode.forEach(user -> {

            log.debug("Loading user json: {}", user);
            user entity = parseJSONUser(user);

            userService.createAnUser(entity);
            });
    }


    public user parseJSONUser(JsonNode jsonNode){
        user node = new user();

        node.setFullName(jsonNode.get("fullName").asText());
        node.setUserName(jsonNode.get("userName").asText());
        node.setPassword(jsonNode.get("password").asText());
        node.setUserEmail(jsonNode.get("userEmail").asText());
        node.setPrivilegeN(jsonNode.get("privilegeN").asInt());
        node.setImage(jsonNode.get("image").asText());
        return node;
    }




    public void loadProduct(String path) throws IOException {
        File file = ResourceUtils.getFile(path);
        byte[] fileContent = Files.readAllBytes(file.toPath());
        JsonNode rootNode = objectMapper.readTree(fileContent);
        rootNode.forEach(product -> {

            log.debug("Loading product json: {}", product);

            product entity = parseJSONProduct(product);

            productService.createAnProduct(entity);
        });
    }


    public product parseJSONProduct(JsonNode jsonNode){
        product node = new product();
        node.setBrandID(jsonNode.get("brandID").asInt());
        node.setDescription(jsonNode.get("description").asText());
        node.setItemNo(jsonNode.get("itemNo").asInt());
        node.setPrdTypeID(jsonNode.get("prdTypeID").asInt());
        node.setPrdTypeMainID(jsonNode.get("prdTypeMainID").asInt());
        node.setProdName(jsonNode.get("prodName").asText());
        node.setProdPrice(jsonNode.get("prodPrice").asInt());
        node.setRate(jsonNode.get("rate").asInt());
        node.setSalesNo(jsonNode.get("salesNo").asInt());
        node.setState(jsonNode.get("state").asText());


        return node;
    }




    public void loadClient(String path) throws IOException {

        File file = ResourceUtils.getFile(path);
        byte[] fileContent = Files.readAllBytes(file.toPath());
        JsonNode rootNode = objectMapper.readTree(fileContent);
        rootNode.forEach(client -> {

            log.debug("Loading client json: {}", client);
            client entity = parseJSONClient(client);

            this.clientService.createAnClient(entity);
        });
    }
    public client parseJSONClient(JsonNode jsonNode){
        client node = new client();
        node.setClientEmail(jsonNode.get("clientEmail").asText());
        node.setClientImage(jsonNode.get("clientImage").asText());
        node.setClientName(jsonNode.get("clientName").asText());
        node.setClientPassword(jsonNode.get("clientPassword").asText());
        node.setGender(jsonNode.get("gender").asText());
        node.setPhone(jsonNode.get("phone").asText());



        return node;
    }


    private void clearData() {
        try {
            this.brandService.deleteAllBrands();
            this.userService.deleteALlUsers();
            this.productService.deleteAllProduct();
            this.clientService.deleteAllClients();
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


//          clearData();
//            load();
//        }
    }

    }
