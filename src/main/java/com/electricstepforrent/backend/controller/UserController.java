package com.electricstepforrent.backend.controller;

import com.electricstepforrent.backend.model.User;
import com.electricstepforrent.backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
//@CrossOrigin(origins = "http://localhost:5176",
//        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT}
//)
@CrossOrigin("*")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getUsers() {
        return service.getAllUsers();
    }

//    @PostMapping
//    public User createUser(@RequestBody User user) {
//        return service.createUser(user);
//    }
    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        boolean deleted = service.deleteUser(id);

        if (deleted) {
            return ResponseEntity.ok("User with ID " + id + " deleted successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User not found");
        }
    }
}