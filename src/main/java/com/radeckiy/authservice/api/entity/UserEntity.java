package com.radeckiy.authservice.api.entity;

import com.radeckiy.authservice.api.domain.UserRoleEnum;
import com.radeckiy.authservice.api.dto.UserDto;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "user")
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Builder.Default
    Instant createdAt = Instant.now();
    @Size(min = 2, message = "Не меньше 5 знаков")
    String username;
    @Size(min = 2, message = "Не меньше 5 знаков")
    String password;
    @Enumerated(EnumType.STRING)
    UserRoleEnum role;
    Boolean deleted = false;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //TODO: Add block-list, return true if the user is not in the block-list
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isAccountNonLocked() && !deleted;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getPermittedOperations();
    }
}
