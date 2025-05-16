/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myapp.controller;

import java.util.List;
import myapp.dto.userRole.UserRoleDTO;
import myapp.dto.userRole.UserRoleSaveDTO;
import myapp.service.ISuperService;
import myapp.service.ServiceFactory;
import myapp.service.custom.IUserRoleService;

/**
 *
 * @author HP
 */
public class UserRoleController {
  
    //------- [Start : downcast] ------------------------------
    
    //reference of type ISuperService (parent class)
    private IUserRoleService userRoleService;

    //constructor
    public UserRoleController() {
        ISuperService iSuperService = ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceType.UserRole);
        
        if (iSuperService instanceof IUserRoleService iUserRoleService) { 
            userRoleService = iUserRoleService; //downcast (parent class -> child class)
        } else {
            throw new IllegalStateException("Returned service is not an instance of IUserRoleService");
        }
    }
    //------- [End : downcast] ------------------------------

    public String addUserRole(UserRoleSaveDTO userRoleSaveDTO) throws Exception {
        return userRoleService.addUserRole(userRoleSaveDTO);
    }

    public String updateUserRole(UserRoleDTO userRoleDTO) throws Exception {
        return userRoleService.updateUserRole(userRoleDTO);
    }

    public String deleteUserRole(Integer id) throws Exception {
        return userRoleService.deleteUserRole(id);
    }

    public UserRoleDTO getUserRoleById(Integer id) throws Exception {
        return userRoleService.getUserRoleById(id);
    }

    public List<UserRoleDTO> getAllUserRoles() throws Exception {
        return userRoleService.getAllUserRoles();
    }
}
