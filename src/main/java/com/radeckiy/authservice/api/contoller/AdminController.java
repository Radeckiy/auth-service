package com.radeckiy.authservice.api.contoller;

import com.radeckiy.authservice.api.entity.UserEntity;
import com.radeckiy.authservice.api.exception.NotFoundUserException;
import com.radeckiy.authservice.api.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/admin")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdminController {
    UserService userService;

    @GetMapping(value = "/")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> result = userService.allUsers();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<UserEntity> getOneUser(@PathVariable("userId") Long userId) {
        UserEntity result;

        try {
            result = userService.findUserById(userId);
        } catch (NotFoundUserException ex) {
            ex.printStackTrace();
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(userService.markUserAsDeleted(userId));
    }
}
