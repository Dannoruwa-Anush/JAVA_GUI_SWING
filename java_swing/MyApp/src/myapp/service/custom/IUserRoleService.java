/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package myapp.service.custom;

import java.util.List;
import myapp.dto.userRole.UserRoleDTO;
import myapp.dto.userRole.UserRoleSaveDTO;
import myapp.service.ISuperService;

/**
 *
 * @author HP
 */
public interface IUserRoleService extends ISuperService{
    String addUserRole(UserRoleSaveDTO userRoleSaveDTO) throws Exception;
    String updateUserRole(UserRoleDTO userRoleDTO) throws Exception;
    String deleteUserRole(Integer id) throws Exception;
    UserRoleDTO getUserRoleById(Integer id) throws Exception;
    List<UserRoleDTO> getAllUserRoles() throws Exception;
}
