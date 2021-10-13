package com.radeckiy.authservice.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.radeckiy.authservice.api.domain.UserRoleEnum;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {
    Long id;
    @JsonProperty("created_at")
    Instant createdAt;
    String username;
    String password;
    UserRoleEnum role;
    Boolean deleted = false;
}
