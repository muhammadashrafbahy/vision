package vision.army.v1;

import vision.army.reprositery.*;
import vision.army.entity.*;
import vision.army.exception.*;
import vision.army.service.*;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/vision/register")
@Api(description = "register or create new entity")
public class register {
    private final userService userService;
    private final clientService clientService;

    public register(userService userService,clientService clientService) {
        this.userService = userService;
        this.clientService= clientService;
    }

    @Transactional
    @ApiOperation(value = "create new user")
    @PostMapping(value = "/user"    , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createNewEmployee(@Valid @RequestBody user user ){
        this.userService.createAnUser(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .replacePath("/vision/user")
                .path("/" + user.getUserID())
                .buildAndExpand().toUri();

        return  ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).build();


    }

    @Transactional
    @ApiOperation("create a new client")
    @PostMapping(value = "/client",produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createAnewClient(@Valid @RequestBody client client) {
        this.clientService.createAnClient(client);
        URI location =ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .replacePath("/vision/client")
                .path("/"+client.getClientID())
                .buildAndExpand().toUri();
        return ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).build();

    }

}
