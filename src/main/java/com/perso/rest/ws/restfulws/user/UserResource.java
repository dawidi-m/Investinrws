package com.perso.rest.ws.restfulws.user;

import com.perso.rest.ws.restfulws.exception.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    private UserDaoService service;

    public UserResource(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    @GetMapping("/users/{userID}")
    public User retrieveOneUser(@PathVariable String userID){
        User user = service.findOne(Integer.parseInt(userID));
        if(user == null){
          throw new UserNotFoundException("id:"+userID);
        }
        return user;
    }
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
      User savedUser = service.saveUser(user);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{userID}")
    public void deleteOneUser(@PathVariable String userID){
        User user = service.findOne(Integer.parseInt(userID));
        if(user == null){
            throw new UserNotFoundException("id:"+userID);
        }
        service.deleteById(user.getId());

    }
}
