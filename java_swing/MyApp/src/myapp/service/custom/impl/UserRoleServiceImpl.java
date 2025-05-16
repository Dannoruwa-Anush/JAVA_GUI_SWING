/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myapp.service.custom.impl;

import java.util.ArrayList;
import java.util.List;
import myapp.dao.DaoFactory;
import myapp.dao.custom.IUserRoleDao;
import myapp.dto.userRole.UserRoleDTO;
import myapp.dto.userRole.UserRoleSaveDTO;
import myapp.entity.UserRoleEntity;
import myapp.service.custom.IUserRoleService;

/**
 *
 * @author HP
 */
public class UserRoleServiceImpl implements IUserRoleService{
    
    IUserRoleDao userRoleDao = (IUserRoleDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.USER_ROLE);
    
    @Override
    public String addUserRole(UserRoleSaveDTO userRoleSaveDTO) throws Exception {
        if(userRoleDao.save(new UserRoleEntity(0, userRoleSaveDTO.getRole_name()))){
            return "Successfully Added";
        }
        else{
            return "Fail";
        }
    }

    @Override
    public String updateUserRole(UserRoleDTO userRoleDTO) throws Exception {
        if(userRoleDao.update(new UserRoleEntity(userRoleDTO.getRole_id(), userRoleDTO.getRole_name()))){
            return "Successfully Updated";
        } else{
            return "Fail";
        }
    }

    @Override
    public String deleteUserRole(Integer id) throws Exception {
        if(userRoleDao.delete(id)){
            return "Successfully Deleted";
        } else{
            return "Fail";
        }
    }

    @Override
    public UserRoleDTO getUserRoleById(Integer id) throws Exception {
        UserRoleEntity userRoleEntity = userRoleDao.getById(id);
        return new UserRoleDTO(userRoleEntity.getRole_id(), userRoleEntity.getRole_name());
    }

    @Override
    public List<UserRoleDTO> getAllUserRoles() throws Exception {
        List<UserRoleDTO> dtos = new ArrayList<>();
        List<UserRoleEntity> customerEntitys = userRoleDao.getAll();
        for (UserRoleEntity customerEntity : customerEntitys) {
            dtos.add(new UserRoleDTO(customerEntity.getRole_id(), customerEntity.getRole_name()));
        }
        
        return dtos;
    }
    
}
