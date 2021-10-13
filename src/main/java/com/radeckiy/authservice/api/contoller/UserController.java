package com.radeckiy.authservice.api.contoller;

import com.radeckiy.authservice.api.entity.UserEntity;
import com.radeckiy.authservice.api.dto.UserDto;
import com.radeckiy.authservice.api.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/admin")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserController {
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Boolean> registerUser(UserDto user) {
        UserEntity userEntity =
    }
}
