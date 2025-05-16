/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myapp.service.custom.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import myapp.dao.DaoFactory;
import myapp.dao.ISuperDAO;
import myapp.dao.custom.IUserRoleDao;
import myapp.dto.userRole.UserRoleDTO;
import myapp.dto.userRole.UserRoleSaveDTO;
import myapp.entity.UserRoleEntity;
import myapp.mapper.UserRoleMapper;
import myapp.service.custom.IUserRoleService;

/**
 *
 * @author HP
 */
public class UserRoleServiceImpl implements IUserRoleService{
    
    //Log : for update, delete
    private static final Logger LOGGER = Logger.getLogger(UserRoleServiceImpl.class.getName());
    
    //------- [Start : downcast] ------------------------------
    
    //reference of type ISuperService (parent class)
    private IUserRoleDao userRoleDao;
    
    //constructor
    public UserRoleServiceImpl(){
        ISuperDAO iSuperDAO = DaoFactory.getDaoFactory().getDao(DaoFactory.DaoType.USER_ROLE);
        
        if(iSuperDAO instanceof IUserRoleDao iUserRoleDao){
            userRoleDao = iUserRoleDao; //downcast (parent class -> child class)
        }
        else {
            throw new IllegalStateException("Returned dao is not an instance of IUserRoleDao");
        }
    }
    //------- [End : downcast] ------------------------------
    
    
    @Override
    public String addUserRole(UserRoleSaveDTO userRoleSaveDTO) throws Exception {
        UserRoleEntity userRole = UserRoleMapper.toEntity(userRoleSaveDTO);
        boolean success = userRoleDao.save(userRole);
        if (success) {
            return "Successfully Added";
        } else {
            return "Fail";
        }
    }

    @Override
    public String updateUserRole(UserRoleDTO userRoleDTO) throws Exception {
        if (userRoleDao.update(new UserRoleEntity(userRoleDTO.getRole_id(), userRoleDTO.getRole_name()))) {
            LOGGER.log(Level.INFO, "User role with ID {0} updated successfully", userRoleDTO.getRole_id());
            return "Successfully Updated";
        } else {
            LOGGER.log(Level.INFO, "Failed to update user role with ID {0}", userRoleDTO.getRole_id());
            return "Fail";
        }
    }

    @Override
    public String deleteUserRole(Integer id) throws Exception {
        if (userRoleDao.delete(id)) {
            LOGGER.log(Level.INFO, "User role with ID {0} deleted successfully", id);
            return "Successfully Deleted";
        } else {
            LOGGER.log(Level.INFO, "Failed to delete user role with ID {0}", id);
            return "Fail";
        }
    }

    @Override
    public UserRoleDTO getUserRoleById(Integer id) throws Exception {
        UserRoleEntity userRoleEntity = userRoleDao.getById(id);
        if (userRoleEntity != null) {
            return new UserRoleDTO(userRoleEntity.getRole_id(), userRoleEntity.getRole_name());
        } else {
            return null;
        }
    }

    @Override
    public List<UserRoleDTO> getAllUserRoles() throws Exception {
        List<UserRoleDTO> dtos = new ArrayList<>();
        List<UserRoleEntity> userRoleEntities = userRoleDao.getAll();
        for (UserRoleEntity entity : userRoleEntities) {
            dtos.add(new UserRoleDTO(entity.getRole_id(), entity.getRole_name()));
        }
        return dtos;
    }
}
