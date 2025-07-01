package com.bookteria.identity.identityservice.mapper;

import org.mapstruct.Mapper;

import com.bookteria.identity.identityservice.dto.request.PermissionRequest;
import com.bookteria.identity.identityservice.dto.response.PermissionResponse;
import com.bookteria.identity.identityservice.entity.Permission;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
