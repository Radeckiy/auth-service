package com.radeckiy.authservice.api.domain;

import org.springframework.security.core.GrantedAuthority;

public enum UserRoleOperationEnum implements GrantedAuthority {
    DELETE,
    READ,
    CREATE;

    @Override
    public String getAuthority() {
        return name();
    }
}
