package com.radeckiy.authservice.api.factories;

import com.radeckiy.authservice.api.dto.UserDto;
import com.radeckiy.authservice.api.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserDtoFactory {
    public UserDto makeUserDto(UserEntity entity) {
        return UserDto.builder()
                .id(entity.getId())
                .createdAt(entity.getCreatedAt())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .role(entity.getRole())
                .deleted(entity.getDeleted())
                .build();
    }
}
