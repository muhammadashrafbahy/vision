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
@RequestMapping("/register")
@Api(description = "register or create new entity")
public class register {
    private final userService userService;

    public register(userService userService) {
        this.userService = userService;
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

}
