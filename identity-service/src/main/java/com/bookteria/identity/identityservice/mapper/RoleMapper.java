package com.bookteria.identity.identityservice.mapper;

import com.bookteria.identity.identityservice.dto.request.RoleRequest;
import com.bookteria.identity.identityservice.dto.response.RoleResponse;
import com.bookteria.identity.identityservice.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}