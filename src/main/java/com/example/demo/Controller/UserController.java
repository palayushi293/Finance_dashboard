package com.example.demo.Controller;

import com.example.demo.Model.Role;
import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    // Add user
    @PostMapping("/add")
    public Object addUser(@RequestBody User user,
                          @RequestParam String role) {
        if (!"ADMIN".equalsIgnoreCase(role)) {
            return "Access Denied. Only ADMIN can add users";
        }
        return service.save(user);
    }

    // Get all users
    @GetMapping("/all")
    public List<User> getAll() {
        return service.getAll();
    }

    // Edit user
    @PutMapping("/edit/{id}")
    public Object editUser(@PathVariable String id,
                           @RequestBody User updatedUser,
                           @RequestParam String role) {
        if (!"ADMIN".equalsIgnoreCase(role)) {
            return "Access Denied. Only ADMIN can edit users";
        }

        Optional<User> optionalUser = service.getById(id);
        if (optionalUser.isEmpty()) {
            return "User not found";
        }

        User user = optionalUser.get();
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setRole(updatedUser.getRole());
        user.setActive(updatedUser.isActive());

        return service.save(user);
    }

    // Delete user
    @DeleteMapping("/delete/{id}")
    public Object deleteUser(@PathVariable String id,
                             @RequestParam String role) {
        if (!"ADMIN".equalsIgnoreCase(role)) {
            return "Access Denied. Only ADMIN can delete users";
        }

        Optional<User> optionalUser = service.getById(id);
        if (optionalUser.isEmpty()) {
            return "User not found";
        }

        service.delete(id);
        return "User deleted successfully";
    }
}