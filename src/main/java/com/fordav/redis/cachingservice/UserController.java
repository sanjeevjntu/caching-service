package com.fordav.redis.cachingservice;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping("/users")
    public User createUser() {
        return userRepository.save(new User("Sanjeev", "VIN1234"));
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable String id) {
        return userRepository.findById(id).orElseThrow();
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable String id) {
        User userById = getUserById(id);
        userById.setName("KUMAR Rajanala");
        return userRepository.save(userById);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        return userList;
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable String id) {
        userRepository.deleteById(id);
    }

}
