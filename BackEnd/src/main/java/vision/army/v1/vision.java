package vision.army.v1;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import vision.army.v1.ApiResource.*;
import vision.army.entity.*;
import vision.army.exception.*;
import vision.army.service.*;
import io.swagger.annotations.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URL;

@RestController
@RequestMapping("/vision")
@Api(description = "manage and execute  ")
public class vision {
    private userService userService;

    public vision(userService userService) {
        this.userService = userService;
    }
    @Transactional
    @ApiOperation("get all users ")
    @GetMapping(value = "/user",produces = MediaType.APPLICATION_JSON_VALUE)
    public usersResources getAllUsers(){
        return new usersResources(this.userService.getAllUsers());

    }
    @Transactional
    @ApiOperation("get detail of  user according to given id ")
    @GetMapping(value = "/user/{userID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public userResource getUserDetails(@PathVariable("userID") int userID ){

        return new userResource(this.userService.getAnUser(userID));

    }
    @Transactional
    @ApiOperation("update detail of  user according to given id ")
    @PutMapping(value = "/user/{userID}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateUserDetails(@PathVariable("userID") int userID  , @Valid @RequestBody user user){

        this.userService.updateAnUser(userID , user);

        URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .buildAndExpand()
                    .toUri();

        return ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).build();

    }


    @Transactional
    @ApiOperation("delete user according to given id ")
    @DeleteMapping(value = "/user/{userID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteUser(@PathVariable("userID") int userID){

        this.userService.deleteAnUser(userID);

        return ResponseEntity.noContent().build();

    }
}
