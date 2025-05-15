/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myapp.dao.custom.impl;

import java.sql.SQLException;
import java.util.List;
import myapp.dao.CrudUtil;
import myapp.dao.custom.IUserRoleDao;
import myapp.entity.UserRoleEntity;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class UserRoleDaoImpl implements IUserRoleDao{

    @Override
    public boolean save(UserRoleEntity t) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO user_roles (role_name) VALUES (?)", t.getRole_name());
    }

    @Override
    public boolean update(UserRoleEntity t) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("UPDATE user_roles SET role_name =? WHERE role_id = ?", t.getRole_name(), t.getRole_id());
    }

    @Override
    public boolean delete(Integer id) throws SQLException, ClassNotFoundException {
         return CrudUtil.executeUpdate("DELETE FROM user_roles WHERE role_id = ?", id);
    }

    @Override
    public UserRoleEntity getById(Integer id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM user_roles where role_id = ?", id);
        
        while (resultSet.next()) {
            return new UserRoleEntity(
                    resultSet.getInt("role_id"), 
                    resultSet.getString("role_name"));
        }
        return null;
    }

    @Override
    public List<UserRoleEntity> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM user_roles");
        List<UserRoleEntity> userRoleEntities = new ArrayList<>();
        while (resultSet.next()) {
            userRoleEntities.add(new UserRoleEntity(
                    resultSet.getInt("role_id"), 
                    resultSet.getString("role_name")));
        }
        return userRoleEntities;
    }
    
}
