/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myapp.mapper;

import myapp.dto.userRole.UserRoleSaveDTO;
import myapp.entity.UserRoleEntity;

/**
 *
 * @author HP
 */
public class UserRoleMapper {
    
    //DTO to entity conversion
    public static UserRoleEntity toEntity(UserRoleSaveDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("UserRoleSaveDTO must not be null");
        }

        UserRoleEntity entity = new UserRoleEntity();
        entity.setRole_name(dto.getRole_name());
        
        return entity;
    }
}
