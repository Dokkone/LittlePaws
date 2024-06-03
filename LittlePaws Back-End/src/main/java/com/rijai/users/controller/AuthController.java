package com.rijai.users.controller;

import com.rijai.users.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rijai.users.services.UserService;
import com.rijai.users.model.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class AuthController {

    private UserService userService;
    private UserRepository userRepository;


    public AuthController(UserService userService,UserRepository userRepository)
    {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @RequestMapping("/")
    public List<User> getAllUser() { return userService.getAllUsers(); }

    @RequestMapping(value="/add-user", method= RequestMethod.POST)
    public User addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ResponseEntity<User> loginUser(@RequestBody User user)
    {
        User existingUser = userRepository.findByEmail(user.getEmail());

        if(existingUser != null)
        {
            return ResponseEntity.ok(existingUser);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

//    @RequestMapping(value="/login", method = RequestMethod.POST)
//    public ResponseEntity<User> loginUser(@RequestBody User user)
//    {
//        User exUser = userRepository.findByUsernameAndPassword(user.getEmail(),user.getPassword());
//
//        if(exUser != null)
//        {
//            return ResponseEntity.ok(exUser);
//        }
//        else
//        {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
//        }
//    }

    // Working
//    @RequestMapping(value="/login", method = RequestMethod.POST)
//    public ResponseEntity<String> loginUser(@RequestBody User user)
//    {
//        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
//
//        if (existingUser.isEmpty()) {
//            return ResponseEntity.badRequest().body("User not found");
//        }
//
//        if(!user.getPassword().equals(existingUser.get().getPassword()))
//        {
//            return ResponseEntity.badRequest().body("Invalid credentials");
//        }
//
//
//        return ResponseEntity.ok("Success");
//    }

//    @PostMapping("/login")
//    public ResponseEntity<Long> login(@RequestBody LoginRequest loginRequest) {
//        String username = loginRequest.getUsername();
//        String password = loginRequest.getPassword();
//
//        // Authenticate the user
//        if (userService.authenticate(username, password)) {
//            // Retrieve the user by username
//            User user = userService.findByUsername(username);
//
//            // Check if the user exists
//            if (user != null) {
//                // Return the user's ID
//                return ResponseEntity.ok(user.getId());
//            }
//        }
//
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(-1L); // Return -1 for unauthorized
//    }

//    @RequestMapping("/{id}")
//    public User showUser(@PathVariable long id) {
//        return userService.getUser(id);
//    }

}
