package com.radeckiy.authservice.api.domain;

import java.util.EnumSet;
import java.util.Set;

public enum UserRoleEnum {
    ADMIN(EnumSet.of(UserRoleOperationEnum.DELETE, UserRoleOperationEnum.READ, UserRoleOperationEnum.CREATE)),
    STAFF(EnumSet.of(UserRoleOperationEnum.READ, UserRoleOperationEnum.CREATE)),
    USER(EnumSet.of(UserRoleOperationEnum.CREATE));

    private final EnumSet<UserRoleOperationEnum> permittedOperations;

    UserRoleEnum(EnumSet<UserRoleOperationEnum> permittedOperations) {
        this.permittedOperations = permittedOperations;
    }

    public Set<UserRoleOperationEnum> getPermittedOperations() {
        return permittedOperations;
    }
}
